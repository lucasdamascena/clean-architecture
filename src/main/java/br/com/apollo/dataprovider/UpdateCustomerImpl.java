package br.com.apollo.dataprovider;

import br.com.apollo.core.dataprovider.UpdateCustomer;
import br.com.apollo.core.domain.Customer;
import br.com.apollo.dataprovider.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerImpl implements UpdateCustomer {

    private final CustomerRepository customerRepository;

    public UpdateCustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer.toEntity());
    }
}
