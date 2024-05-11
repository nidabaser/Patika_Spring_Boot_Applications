package dev.nida.RESTAPI.dto;

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
public class CustomerDto {
    private int id;
    private String name;
    private String mail;
}
