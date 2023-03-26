package br.com.apollo.core.usecase.impl;

import br.com.apollo.core.dataprovider.FindAddressByZipCode;
import br.com.apollo.core.dataprovider.InsertCustomer;
import br.com.apollo.core.dataprovider.SendCpfForValidation;
import br.com.apollo.core.domain.Customer;
import br.com.apollo.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;
    private final SendCpfForValidation sendCpfForValidation;

    public InsertCustomerUseCaseImpl(FindAddressByZipCode findAddressByZipCode,
                                     InsertCustomer insertCustomer,
                                     SendCpfForValidation sendCpfForValidation) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
        this.sendCpfForValidation = sendCpfForValidation;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);

        insertCustomer.insert(customer);
        sendCpfForValidation.send(customer.getCpf());
    }
}
