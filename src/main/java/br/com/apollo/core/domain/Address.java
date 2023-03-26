package br.com.apollo.core.domain;

import br.com.apollo.dataprovider.repository.entity.AddressEntity;
import br.com.apollo.entrypoint.controller.response.AddressResponse;

public class Address {

    private String street;

    private String city;

    private String state;

    public Address() {
    }

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public AddressEntity toEntity() {
        return new AddressEntity(street, city, state);
    }

    public AddressResponse toResponse() {
        return new AddressResponse(street, city, state);
    }
}
