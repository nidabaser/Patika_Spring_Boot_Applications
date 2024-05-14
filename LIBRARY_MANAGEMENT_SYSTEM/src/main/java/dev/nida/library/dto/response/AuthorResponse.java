package dev.nida.library.dto.response;

/**
 * @author Nida Başer
 * May 2024
 */

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {

    @Positive
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String country;
}