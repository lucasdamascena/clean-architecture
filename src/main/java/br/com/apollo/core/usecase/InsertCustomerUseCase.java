package br.com.apollo.core.usecase;

import br.com.apollo.core.domain.Customer;

public interface InsertCustomerUseCase {

    void insert(Customer customer, final String zipCode);
}
