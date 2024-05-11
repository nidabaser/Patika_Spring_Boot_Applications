package dev.nida.RESTAPI.dto;

import dev.nida.RESTAPI.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nida Başer
 * May 2024
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    private int id;
    private String name;
    private Customer.Gender gender;
}
