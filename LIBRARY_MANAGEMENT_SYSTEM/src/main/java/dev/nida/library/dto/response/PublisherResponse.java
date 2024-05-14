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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherResponse {

    @Positive
    private Long id;

    private String name;

    private Integer establishmentYear;

}
