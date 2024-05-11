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
//POJO class, Customer Object --> CustomerDto Object dönüştürmek için
public class CustomerResponse {
    private int id;
    @NotNull
    private String name;
    @Email
    private String mail;
    private Customer.Gender gender; // Mesela yeni alan ekledik, getAll 'da yoktu buraya yazmak yetiyor artık getAll'da gözükücek (POSTMAN'de)

}
