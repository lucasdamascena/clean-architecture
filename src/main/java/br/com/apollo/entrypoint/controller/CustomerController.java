package br.com.apollo.entrypoint.controller;

import br.com.apollo.core.domain.Customer;
import br.com.apollo.core.usecase.DeleteCustomerByIdUseCase;
import br.com.apollo.core.usecase.FindCustomerByIdUseCase;
import br.com.apollo.core.usecase.InsertCustomerUseCase;
import br.com.apollo.core.usecase.UpdateCustomerUseCase;
import br.com.apollo.entrypoint.controller.request.CustomerRequest;
import br.com.apollo.entrypoint.controller.response.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerUseCase insertCustomerUseCase;

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    private final UpdateCustomerUseCase updateCustomerUseCase;

    private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    public CustomerController(InsertCustomerUseCase insertCustomerUseCase,
                              FindCustomerByIdUseCase findCustomerByIdUseCase,
                              UpdateCustomerUseCase updateCustomerUseCase,
                              DeleteCustomerByIdUseCase deleteCustomerByIdUseCase) {
        this.insertCustomerUseCase = insertCustomerUseCase;
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
        this.deleteCustomerByIdUseCase = deleteCustomerByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerRequest.toDomain();
        insertCustomerUseCase.insert(customer, customerRequest.getZipCode());

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{id}")
    public CustomerResponse findCustomerById(@PathVariable("id") final String id) {
        Customer customer = findCustomerByIdUseCase.find(id);

        return customer.toResponse();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") final String id,
                                       @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerRequest.toDomain();
        customer.setId(id);
        updateCustomerUseCase.update(customer, customerRequest.getZipCode());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        deleteCustomerByIdUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
