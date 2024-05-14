package dev.nida.library.dto.request;

/**
 * @author Nida Başer
 * May 2024
 */

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookForBorrowingRequest {

    @Positive
    private Long id;

    private String name;

    private int publicationYear;

    @Positive(message = "Stock must be positive number")
    private int stock;

}
