package br.com.apollo.entrypoint.controller;

import br.com.apollo.core.domain.Customer;
import br.com.apollo.core.usecase.InsertCustomerUseCase;
import br.com.apollo.entrypoint.controller.request.CustomerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerUseCase insertCustomerUseCase;

    public CustomerController(InsertCustomerUseCase insertCustomerUseCase) {
        this.insertCustomerUseCase = insertCustomerUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerRequest.toDomain();
        insertCustomerUseCase.insert(customer, customerRequest.getZipCode());

        return ResponseEntity.ok().build();
    }
}
