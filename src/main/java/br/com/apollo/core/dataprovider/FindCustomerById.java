package br.com.apollo.core.dataprovider;

import br.com.apollo.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {

    Optional<Customer> find(final String id);
}
