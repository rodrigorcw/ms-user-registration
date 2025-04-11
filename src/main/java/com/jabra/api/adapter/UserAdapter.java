package com.jabra.api.adapter;

import com.jabra.api.application.dto.AddressDto;
import com.jabra.api.application.dto.UserDto;
import com.jabra.api.domain.model.Address;
import com.jabra.api.domain.model.User;

public class UserAdapter {

    public static UserDto toDto(User user){
        return new UserDto(user.getName(), user.getCep(), user.getEmail(),toDto(user.getAddress()));
    }

    public static AddressDto toDto(Address address){
        return new AddressDto(address.cep, address.logradouro, address.bairro, address.localidade, address.uf, address.estado);
    }

    public static User toEntity(UserDto userDto, Address address){
        return new User(null,userDto.getName(),userDto.getCep(), userDto.getEmail(),address);
    }

    public static Address toEntity(AddressDto addressDTO){
        return new Address(null,addressDTO.cep, addressDTO.logradouro,  addressDTO.bairro, addressDTO.localidade, addressDTO.uf, addressDTO.estado);
    }

}
