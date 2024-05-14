package dev.nida.library.dto.request;

/**
 * @author Nida Başer
 * May 2024
 */

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
public class BookBorrowingUpdateRequest {

    @NotNull(message = "Borrower name can not be null")
    private String borrowerName;

    private LocalDate borrowingDate;

    private LocalDate returnDate;

}
