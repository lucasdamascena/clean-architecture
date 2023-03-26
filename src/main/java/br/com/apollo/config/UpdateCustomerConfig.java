package br.com.apollo.config;

import br.com.apollo.core.usecase.impl.UpdateCustomerUseCaseImpl;
import br.com.apollo.dataprovider.FindAddressByZipCodeImpl;
import br.com.apollo.dataprovider.FindCustomerByIdImpl;
import br.com.apollo.dataprovider.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(FindCustomerByIdImpl findCustomerById,
                                                           FindAddressByZipCodeImpl findAddressByZipCode,
                                                           UpdateCustomerImpl updateCustomer) {
        return new UpdateCustomerUseCaseImpl(findCustomerById, findAddressByZipCode, updateCustomer);
    }
}
