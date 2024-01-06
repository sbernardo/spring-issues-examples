package com.bernardo.spring.issues.sof.questions.repository;

import com.bernardo.spring.issues.sof.questions.model.DocumentEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface DocumentRepository extends MongoRepository<DocumentEntity, String> {

    @Aggregation(
            pipeline = {"""
                    {
                        '$match': {
                            $and: [
                                ?#{ [0] == null || [0].isEmpty() ? { _id: { $exists: true } } : { field1 : { $in: [0] } } },
                                ?#{ T(org.apache.commons.lang3.StringUtils).isBlank([1]) ? { _id: { $exists: true } } : { field2 : { $regex: '.*' + [1] + '.*', $options: 'i' } } },
                                ?#{ [2] == null ? { _id: { $exists: true } } : { field3 : { $gte: [2] } } },
                                ?#{ [3] == null ? { _id: { $exists: true } } : { field3 : { $lte: [3] } } }
                            ]
                        }
                    }
                    """
            }
    )
    List<DocumentEntity> findDocument(List<String> field1, String field2, Date field3LowerBound, Date field3UpperBound);

}
