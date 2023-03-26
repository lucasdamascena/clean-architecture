package br.com.apollo.dataprovider;

import br.com.apollo.core.dataprovider.FindCustomerById;
import br.com.apollo.core.domain.Customer;
import br.com.apollo.dataprovider.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdImpl implements FindCustomerById {

    private final CustomerRepository customerRepository;

    public FindCustomerByIdImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);

        return customerEntity.map(entity -> customerEntity.get().toDomain());
    }
}
