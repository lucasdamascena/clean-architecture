package br.com.apollo.core.domain;

import br.com.apollo.dataprovider.repository.entity.CustomerEntity;
import br.com.apollo.entrypoint.controller.response.CustomerResponse;

public class Customer {

    private String id;

    private String name;

    private String cpf;

    private Boolean isValidCpf;

    private Address address;

    /**
     * Quando criamos um cliente, o CPF é validado somente após passar pelo Kafka
     */
    public Customer() {
        this.isValidCpf = false;
    }

    public Customer(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public Customer(String id, String name, String cpf, Boolean isValidCpf, Address address) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CustomerEntity toEntity() {
        return new CustomerEntity(id, name, cpf, isValidCpf, address.toEntity());
    }

    public CustomerResponse toResponse() {
        return new CustomerResponse(name, cpf, isValidCpf, address.toResponse());
    }
}
