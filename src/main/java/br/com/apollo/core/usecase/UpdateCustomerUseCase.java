package br.com.apollo.core.usecase;

import br.com.apollo.core.domain.Customer;

public interface UpdateCustomerUseCase {

    void update(Customer customer, final String zipCode);
}
