package com.addressapicep.controller;

import com.addressapicep.dto.AddressDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/address")
public class AddressController {

    @GetMapping("{cep}")
    public AddressDto getAddressByCep(@PathVariable("cep") String cep){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AddressDto> response = restTemplate.getForEntity(
                String.format("https://viacep.com.br/ws/%s/json/",cep), AddressDto.class);
        return response.getBody();
    }
}
