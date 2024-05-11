package dev.nida.RESTAPI.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;

/**
 * @author Nida Başer
 * May 2024
 */

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", length = 10)
    private int id;

    @Column(name = "customer_name", nullable = false, length = 20)
    @NotNull // VALIDATION
    private String name;

    @Email(message = "Please enter valid email address") // VALIDATION
    @Column(name = "customer_mail", nullable = false, unique = true)
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private Gender gender;

    public enum Gender {
        MALE,
        FEMALE
    }
}