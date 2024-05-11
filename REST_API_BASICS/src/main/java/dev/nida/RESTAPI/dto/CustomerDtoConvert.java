package dev.nida.RESTAPI.dto;

import dev.nida.RESTAPI.entity.Customer;
import org.springframework.stereotype.Component;

/**
 * @author Nida Başer
 * May 2024
 */

@Component
public class CustomerDtoConvert {

    public CustomerDto convertDto(Customer customer) {

        // Uzun yolu
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setId(customer.getId());
//        customerDto.setName(customer.getName());
//        customerDto.setMail(customer.getMail());
//        return customerDto;

        // Kısa yolu
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getMail()
        );
    }
}
