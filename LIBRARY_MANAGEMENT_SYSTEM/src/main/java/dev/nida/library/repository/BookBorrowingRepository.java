package dev.nida.library.repository;

/**
 * @author Nida Başer
 * May 2024
 */

import dev.nida.library.entity.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  BookBorrowingRepository extends JpaRepository<BookBorrowing,Long> {
}