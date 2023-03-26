package br.com.apollo.core.usecase.impl;

import br.com.apollo.core.dataprovider.DeleteCustomerById;
import br.com.apollo.core.dataprovider.FindCustomerById;
import br.com.apollo.core.usecase.DeleteCustomerByIdUseCase;

public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

    private final FindCustomerById findCustomerById;
    private final DeleteCustomerById deleteCustomerById;

    public DeleteCustomerByIdUseCaseImpl(FindCustomerById findCustomerById,
                                         DeleteCustomerById deleteCustomerById) {
        this.findCustomerById = findCustomerById;
        this.deleteCustomerById = deleteCustomerById;
    }

    @Override
    public void delete(String id) {
        findCustomerById.find(id);
        deleteCustomerById.delete(id);
    }
}
