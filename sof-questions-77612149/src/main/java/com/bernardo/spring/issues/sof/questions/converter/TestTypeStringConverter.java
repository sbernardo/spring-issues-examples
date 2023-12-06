package com.bernardo.spring.issues.sof.questions.converter;

import com.bernardo.spring.issues.sof.questions.model.TestType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class TestTypeStringConverter implements Converter<TestType, String> {

    @Override
    public String convert(TestType source) {
        return source.getValue();
    }

}