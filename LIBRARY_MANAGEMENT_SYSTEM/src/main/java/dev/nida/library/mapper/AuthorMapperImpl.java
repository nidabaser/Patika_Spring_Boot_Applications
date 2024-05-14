package dev.nida.library.mapper;

/**
 * @author Nida Başer
 * May 2024
 */

import dev.nida.library.dto.request.AuthorRequest;
import dev.nida.library.dto.response.AuthorResponse;
import dev.nida.library.entity.Author;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author asEntity(AuthorRequest authorRequest) {
        if ( authorRequest == null ) {
            return null;
        }

        Author author = new Author();

        author.setName( authorRequest.getName() );
        author.setBirthDate( authorRequest.getBirthDate() );
        author.setCountry( authorRequest.getCountry() );

        return author;
    }

    @Override
    public AuthorResponse asOutput(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorResponse authorResponse = new AuthorResponse();

        authorResponse.setId( author.getId() );
        authorResponse.setName( author.getName() );
        authorResponse.setBirthDate( author.getBirthDate() );
        authorResponse.setCountry( author.getCountry() );

        return authorResponse;
    }

    @Override
    public List<AuthorResponse> asOutput(List<Author> author) {
        if ( author == null ) {
            return null;
        }

        List<AuthorResponse> list = new ArrayList<AuthorResponse>( author.size() );
        for ( Author author1 : author ) {
            list.add( asOutput( author1 ) );
        }

        return list;
    }

    @Override
    public void update(Author entity, AuthorRequest request) {
        if ( request == null ) {
            return;
        }

        entity.setName( request.getName() );
        entity.setBirthDate( request.getBirthDate() );
        entity.setCountry( request.getCountry() );
    }
}
