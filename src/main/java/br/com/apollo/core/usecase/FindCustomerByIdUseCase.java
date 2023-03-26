package br.com.apollo.core.usecase;

import br.com.apollo.core.domain.Customer;

public interface FindCustomerByIdUseCase {

    Customer find(final String id);
}
