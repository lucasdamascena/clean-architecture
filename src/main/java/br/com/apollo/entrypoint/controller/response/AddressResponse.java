package br.com.apollo.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddressResponse {

    private String street;

    private String city;

    private String state;
}
