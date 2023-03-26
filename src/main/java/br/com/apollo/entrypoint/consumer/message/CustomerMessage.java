package br.com.apollo.entrypoint.consumer.message;

import br.com.apollo.core.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerMessage {

    private String id;

    private String name;

    private String zipCode;

    private String cpf;

    private Boolean isValidCpf;

    public Customer toDomain() {
        return new Customer(id, name, cpf, isValidCpf, null);
    }
}
