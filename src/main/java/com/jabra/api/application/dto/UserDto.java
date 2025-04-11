package com.jabra.api.application.dto;

public class UserDto {

    private String name;
    private String cep;
    private String email;
    private AddressDto addressDTO;

    public UserDto() {
    }

    public UserDto(String name, String cep, String email, AddressDto addressDTO) {
        this.name = name;
        this.cep = cep;
        this.email = email;
        this.addressDTO = addressDTO;
    }

    public AddressDto getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDto addressDTO) {
        this.addressDTO = addressDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
