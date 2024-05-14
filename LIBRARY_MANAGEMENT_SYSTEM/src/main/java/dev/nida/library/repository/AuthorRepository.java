package dev.nida.library.repository;

/**
 * @author Nida Başer
 * May 2024
 */

import dev.nida.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByNameAndBirthDateAndCountry(String name, LocalDate birthDate, String country);
}