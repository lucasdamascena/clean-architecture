package br.com.apollo.dataprovider;

import br.com.apollo.core.dataprovider.InsertCustomer;
import br.com.apollo.core.domain.Customer;
import br.com.apollo.dataprovider.repository.CustomerRepository;
import br.com.apollo.dataprovider.repository.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerImpl implements InsertCustomer {

    private final CustomerRepository customerRepository;

    public InsertCustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customer.toEntity();
        customerRepository.save(customerEntity);
    }
}
