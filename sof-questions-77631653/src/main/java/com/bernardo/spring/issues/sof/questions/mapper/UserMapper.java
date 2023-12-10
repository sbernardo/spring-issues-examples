package com.bernardo.spring.issues.sof.questions.mapper;

import com.bernardo.spring.issues.sof.questions.model.User;
import com.bernardo.spring.issues.sof.questions.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDto toUserDto(User user);

}
