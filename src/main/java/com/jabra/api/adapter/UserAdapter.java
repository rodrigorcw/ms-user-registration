package com.jabra.api.adapter;

import com.jabra.api.application.dto.UserDto;
import com.jabra.api.domain.model.User;

public class UserAdapter {

    public static UserDto toDto(User user){
        return new UserDto(user.getName(), user.getEmail());
    }

    public static User toEntity(UserDto userDto){
        return new User(null,userDto.getName(), userDto.getEmail());
    }
}
