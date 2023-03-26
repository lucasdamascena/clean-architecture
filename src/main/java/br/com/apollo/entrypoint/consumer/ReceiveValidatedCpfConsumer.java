package br.com.apollo.entrypoint.consumer;

import br.com.apollo.core.usecase.UpdateCustomerUseCase;
import br.com.apollo.entrypoint.consumer.message.CustomerMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerUseCase updateCustomerUseCase;

    public ReceiveValidatedCpfConsumer(UpdateCustomerUseCase updateCustomerUseCase) {
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    @KafkaListener(topics = "tp-cpf-validated", groupId = "apollo")
    public void receive(CustomerMessage customerMessage) {
        updateCustomerUseCase.update(customerMessage.toDomain(), customerMessage.getZipCode());
    }
}
