package com.jabra.api.application.service;

import com.jabra.api.adapter.UserAdapter;
import com.jabra.api.application.dto.UserDto;
import com.jabra.api.domain.model.User;
import com.jabra.api.domain.service.UserService;
import com.jabra.api.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserAdapter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        var findUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserAdapter.toDto(findUser);
    }

    @Override
    public UserDto Created(UserDto userDto) {
        User save = userRepository.save(UserAdapter.toEntity(userDto));
        return UserAdapter.toDto(save);

    }

    @Override
    public UserDto Update(Long id, UserDto userDto) {
        User userUp = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        userUp.setName(userDto.getName());
        userUp.setEmail(userDto.getEmail());
        userRepository.save(userUp);
        return UserAdapter.toDto(userUp);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
