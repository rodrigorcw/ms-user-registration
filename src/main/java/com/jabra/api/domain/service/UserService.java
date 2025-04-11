package com.jabra.api.domain.service;

import com.jabra.api.application.dto.UserDto;
import com.jabra.api.domain.model.User;

import java.util.List;

public interface UserService {


    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto Created(UserDto userDto);

    UserDto Update(Long id, UserDto userDto);

    void delete(Long id);


}
