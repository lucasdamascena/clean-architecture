package br.com.apollo.dataprovider;

import br.com.apollo.core.dataprovider.FindAddressByZipCode;
import br.com.apollo.core.domain.Address;
import br.com.apollo.dataprovider.client.FindAddressByZipCodeClient;
import br.com.apollo.dataprovider.client.response.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;

    public FindAddressByZipCodeImpl(FindAddressByZipCodeClient findAddressByZipCodeClient) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
    }

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponse.toDomain();
    }
}
