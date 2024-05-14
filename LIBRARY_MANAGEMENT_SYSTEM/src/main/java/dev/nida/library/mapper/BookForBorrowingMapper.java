package dev.nida.library.mapper;

/**
 * @author Nida Başer
 * May 2024
 */

import dev.nida.library.dto.request.BookForBorrowingRequest;
import dev.nida.library.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookForBorrowingMapper {

    Book asEntity(BookForBorrowingRequest bookForBorrowingRequest);
}
