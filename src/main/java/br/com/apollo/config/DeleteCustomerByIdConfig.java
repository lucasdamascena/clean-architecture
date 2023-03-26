package br.com.apollo.config;

import br.com.apollo.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import br.com.apollo.dataprovider.DeleteCustomerByIdImpl;
import br.com.apollo.dataprovider.FindCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase(FindCustomerByIdImpl findCustomerById,
                                                                   DeleteCustomerByIdImpl deleteCustomerById) {
        return new DeleteCustomerByIdUseCaseImpl(findCustomerById, deleteCustomerById);
    }
}
