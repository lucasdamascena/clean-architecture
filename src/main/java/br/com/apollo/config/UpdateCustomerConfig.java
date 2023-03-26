package br.com.apollo.config;

import br.com.apollo.core.dataprovider.FindAddressByZipCode;
import br.com.apollo.core.dataprovider.FindCustomerById;
import br.com.apollo.core.dataprovider.UpdateCustomer;
import br.com.apollo.core.usecase.impl.UpdateCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(FindCustomerById findCustomerById,
                                                           FindAddressByZipCode findAddressByZipCode,
                                                           UpdateCustomer updateCustomer) {
        return new UpdateCustomerUseCaseImpl(findCustomerById, findAddressByZipCode, updateCustomer);
    }
}
