package br.com.apollo.dataprovider.client.response;

import br.com.apollo.core.domain.Address;
import lombok.Data;

@Data
public class AddressResponse {

    private String street;

    private String city;

    private String state;

    public Address toDomain() {
        return new Address(street, city, state);
    }
}
