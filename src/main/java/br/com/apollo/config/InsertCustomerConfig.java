package br.com.apollo.config;

import br.com.apollo.core.usecase.impl.InsertCustomerUseCaseImpl;
import br.com.apollo.dataprovider.FindAddressByZipCodeImpl;
import br.com.apollo.dataprovider.InsertCustomerImpl;
import br.com.apollo.dataprovider.SendCpfForValidationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(FindAddressByZipCodeImpl findAddressByZipCode,
                                                           InsertCustomerImpl insertCustomer,
                                                           SendCpfForValidationImpl sendCpfForValidation) {
        return new InsertCustomerUseCaseImpl(findAddressByZipCode, insertCustomer, sendCpfForValidation);
    }
}
