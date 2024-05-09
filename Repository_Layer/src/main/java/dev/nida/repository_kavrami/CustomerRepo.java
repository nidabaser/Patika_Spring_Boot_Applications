package dev.nida.repository_kavrami;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Nida Başer
 * May 2024
 */

@Repository // CRUD Repository, JPA Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    Customer findByMail(String mail); // Sadece bu metodu koyarak bize findByMail = SELECT WHERE mail = ? yapar
    // resmen sadece metod ismiyle repodan arama yaptık

    // Birden fazla koşullu arama yapmak için sorgu yerine metod:
    Customer findByMailAndGender(String mail, Customer.Gender gender);

    // Veya için or kullanabiliriz, Liste de alabilriz.
    List<Customer> findByGender(Customer.Gender gender);

    // Ozel Sorgu yazalım
    @Query("FROM Customer as c WHERE c.gender = :gender")
    List<Customer> getQueryByGender(@Param("gender") Customer.Gender gender);

}
