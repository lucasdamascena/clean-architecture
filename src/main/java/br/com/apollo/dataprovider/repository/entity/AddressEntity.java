package br.com.apollo.dataprovider.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddressEntity {

    private String street;

    private String city;

    private String state;
}
