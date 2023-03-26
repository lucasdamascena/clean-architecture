package br.com.apollo.dataprovider;

import br.com.apollo.core.dataprovider.DeleteCustomerById;
import br.com.apollo.dataprovider.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdImpl implements DeleteCustomerById {

    private final CustomerRepository customerRepository;

    public DeleteCustomerByIdImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
