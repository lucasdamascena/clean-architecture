package br.com.apollo.core.usecase.impl;

import br.com.apollo.core.dataprovider.FindAddressByZipCode;
import br.com.apollo.core.dataprovider.FindCustomerById;
import br.com.apollo.core.dataprovider.UpdateCustomer;
import br.com.apollo.core.domain.Customer;
import br.com.apollo.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final FindCustomerById findCustomerById;
    private final FindAddressByZipCode findAddressByZipCode;
    private final UpdateCustomer updateCustomer;

    public UpdateCustomerUseCaseImpl(FindCustomerById findCustomerById,
                                     FindAddressByZipCode findAddressByZipCode,
                                     UpdateCustomer updateCustomer) {
        this.findCustomerById = findCustomerById;
        this.findAddressByZipCode = findAddressByZipCode;
        this.updateCustomer = updateCustomer;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerById.find(customer.getId());

        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);

        updateCustomer.update(customer);
    }
}
