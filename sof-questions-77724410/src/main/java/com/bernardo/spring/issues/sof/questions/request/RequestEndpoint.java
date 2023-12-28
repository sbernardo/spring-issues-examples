package com.bernardo.spring.issues.sof.questions.request;

import com.bernardo.spring.issues.sof.questions.validator.ValidMaxMinDouble;
import lombok.Data;

@ValidMaxMinDouble.List({@ValidMaxMinDouble(
        maxFieldName = "maxOperatingTemperature",
        minFieldName = "minOperatingTemperature",
        message =
                "Maximum operating temperature must not be less than the minimum operating temperature"
)})
@Data
public class RequestEndpoint {

    private Double maxOperatingTemperature;

    private Double minOperatingTemperature;

}
