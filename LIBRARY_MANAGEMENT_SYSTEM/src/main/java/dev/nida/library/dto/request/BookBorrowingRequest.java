package dev.nida.library.dto.request;

/**
 * @author Nida Başer
 * May 2024
 */

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookBorrowingRequest {

    @NotNull(message = "Borrower name can not be null")
    private String borrowerName;

    @Email
    private String borrowerMail;

    private LocalDate borrowingDate;

    private BookForBorrowingRequest bookForBorrowingRequest;
}
