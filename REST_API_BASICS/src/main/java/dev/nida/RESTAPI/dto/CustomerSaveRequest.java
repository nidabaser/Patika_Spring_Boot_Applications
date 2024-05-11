package dev.nida.RESTAPI.dto;

import dev.nida.RESTAPI.entity.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nida Başer
 * May 2024
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSaveRequest {
    // private int id; // Save ederken id gelmeyecek sadece 3 veri istiyoruz
    @NotNull // VALIDATION
    private String name;
    @Email // VALIDATION
    private String mail;
    private Customer.Gender gender;
}
