package dev.nida.library.mapper;

/**
 * @author Nida Başer
 * May 2024
 */

import dev.nida.library.dto.request.AuthorRequest;
import dev.nida.library.dto.response.AuthorResponse;
import dev.nida.library.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface AuthorMapper {

    Author asEntity(AuthorRequest authorRequest);

    AuthorResponse asOutput(Author author);

    List<AuthorResponse> asOutput(List<Author> author);

    void update(@MappingTarget Author entity, AuthorRequest request);
}
