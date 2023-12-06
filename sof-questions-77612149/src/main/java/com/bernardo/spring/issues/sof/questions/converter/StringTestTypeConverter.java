package com.bernardo.spring.issues.sof.questions.converter;

import com.bernardo.spring.issues.sof.questions.model.TestType;
import com.mongodb.lang.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class StringTestTypeConverter implements Converter<String, TestType> {
    @Override
    public TestType convert(@NonNull String source) {
        return new TestType(source);
    }
}