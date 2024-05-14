package dev.nida.library.repository;

/**
 * @author Nida Başer
 * May 2024
 */

import dev.nida.library.entity.Author;
import dev.nida.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByNameAndAuthor(String name, Author author);

    @Query("SELECT b FROM Book b JOIN b.categories c WHERE c.id = :categoryId")
    List<Book> findByCategoryId(Long categoryId);
}