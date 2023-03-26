package br.com.apollo.dataprovider.repository.entity;

import br.com.apollo.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddressEntity {

    private String street;

    private String city;

    private String state;

    public Address toDomain() {
        return new Address(street, city, state);
    }
}
