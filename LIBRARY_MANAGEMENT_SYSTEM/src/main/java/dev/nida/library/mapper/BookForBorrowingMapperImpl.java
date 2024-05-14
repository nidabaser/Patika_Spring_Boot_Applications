package dev.nida.library.mapper;

/**
 * @author Nida Başer
 * May 2024
 */

import dev.nida.library.dto.request.BookForBorrowingRequest;
import dev.nida.library.entity.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class BookForBorrowingMapperImpl implements BookForBorrowingMapper {

    @Override
    public Book asEntity(BookForBorrowingRequest bookForBorrowingRequest) {
        if ( bookForBorrowingRequest == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookForBorrowingRequest.getId() );
        book.setName( bookForBorrowingRequest.getName() );
        book.setPublicationYear( bookForBorrowingRequest.getPublicationYear() );
        book.setStock( bookForBorrowingRequest.getStock() );

        return book;
    }
}