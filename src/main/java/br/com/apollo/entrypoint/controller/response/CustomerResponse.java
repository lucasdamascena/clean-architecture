package br.com.apollo.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerResponse {

    private String name;

    private String cpf;

    private Boolean isValidCpf;

    private AddressResponse address;
}
