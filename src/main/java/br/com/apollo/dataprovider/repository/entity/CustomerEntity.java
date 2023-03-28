package br.com.apollo.dataprovider.repository.entity;

import br.com.apollo.core.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private String id;

    private String name;

    private String cpf;

    private Boolean isValidCpf;

    private AddressEntity address;

    public Customer toDomain() {

        if (isValidCpf == null) {
            isValidCpf = false;
        }

        return new Customer(id, name, cpf, isValidCpf, address.toDomain());
    }
}
