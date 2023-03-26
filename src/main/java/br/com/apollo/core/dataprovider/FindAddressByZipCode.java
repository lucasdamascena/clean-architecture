package br.com.apollo.core.dataprovider;

import br.com.apollo.core.domain.Address;

public interface FindAddressByZipCode {

    Address find(final String zipCode);
}
