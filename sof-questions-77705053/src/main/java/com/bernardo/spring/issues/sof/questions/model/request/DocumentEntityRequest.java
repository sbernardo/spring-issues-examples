package com.bernardo.spring.issues.sof.questions.model.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentEntityRequest {

    @Parameter(in = ParameterIn.QUERY, description = "Field1")
    private List<String> field1;

    @Parameter(in = ParameterIn.QUERY, description = "Field2")
    private String field2;

    @Parameter(in = ParameterIn.QUERY, description = "Field 3 lower bound")
    @Schema(type = "string")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date field3LowerBound;

    @Parameter(in = ParameterIn.QUERY, description = "Field 3 upper bound")
    @Schema(type = "string")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date field3UpperBound;

}
