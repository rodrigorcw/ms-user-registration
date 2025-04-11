package com.jabra.api.infra.feign;

import com.jabra.api.application.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//define a API de destino.
@FeignClient(name = "api-endereco", url = "${api-endereco.url}")
public interface ViaCepClient {
//representa o endpoint da outra API.

    @GetMapping("{cep}/json")
    AddressDto getAddressByCep(@PathVariable("cep") String cep);
}
