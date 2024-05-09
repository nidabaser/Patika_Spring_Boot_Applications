package dev.nida.spring;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * @author Nida Başer
 * May 2024
 */

@Entity
@Table(name = "customers")
// LOMBOK KULLANIMI
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
// YUKARIDAKİLERİN HEPSİNİ TEK BAŞINA YAPAN
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", length = 10)
    private int id;

    @Column(name = "customer_name", nullable = false, length = 20)
    private String name;

    @Column(name = "customer_mail", nullable = false, unique = true)
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private Gender gender;

    public enum Gender{
        MALE,
        FEMALE
    }

    // AŞAĞIYA CONSTRUCTOR GETTER SETTER HİÇ BİŞİ YAZMAYIP LOMBOKLA YAPILIYOR
    // <-- STRUCTURE BOLUMUNDEN YAPIYI GOREBİLİRSİN

}
