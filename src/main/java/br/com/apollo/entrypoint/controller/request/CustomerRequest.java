package br.com.apollo.entrypoint.controller.request;

import br.com.apollo.core.domain.Customer;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String zipCode;

    public Customer toDomain() {
        return new Customer(name, cpf);
    }
}
