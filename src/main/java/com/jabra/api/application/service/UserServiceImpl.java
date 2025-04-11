package com.jabra.api.application.service;

import com.jabra.api.adapter.UserAdapter;
import com.jabra.api.application.dto.AddressDto;
import com.jabra.api.application.dto.UserDto;
import com.jabra.api.domain.model.Address;
import com.jabra.api.domain.model.User;
import com.jabra.api.domain.service.UserService;
import com.jabra.api.infra.feign.ViaCepClient;
import com.jabra.api.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ViaCepClient viaCepClient;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserAdapter::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public UserDto findById(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserAdapter.toDto(user);

    }


    @Override
    public UserDto Created(UserDto userDto) {

        AddressDto address = viaCepClient.getAddressByCep(userDto.getCep());

        User saveUser = userRepository.save(UserAdapter.toEntity(userDto, UserAdapter.toEntity(address)));

        UserDto response = UserAdapter.toDto(saveUser);

        return response;

    }


    @Override
    public UserDto Update(Long id, UserDto userDto) {
        User userUp = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        userUp.setName(userDto.getName());
        userUp.setCep(userDto.getCep());
        userUp.setEmail(userDto.getEmail());

        AddressDto address = viaCepClient.getAddressByCep(userDto.getCep());

        Address userAddress = userUp.getAddress();
        if (userAddress == null) {
            userAddress = new Address(); // Se o usuário ainda não tem endereço
            userUp.setAddress(userAddress);
        }

        userAddress.setCep(address.getCep());
        userAddress.setLogradouro(address.getLogradouro());
        userAddress.setBairro(address.getBairro());
        userAddress.setLocalidade(address.getLocalidade());
        userAddress.setUf(address.getUf());
        userAddress.setEstado(address.getEstado());


        User updatedUser = userRepository.save(userUp);

        return UserAdapter.toDto(userUp);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
