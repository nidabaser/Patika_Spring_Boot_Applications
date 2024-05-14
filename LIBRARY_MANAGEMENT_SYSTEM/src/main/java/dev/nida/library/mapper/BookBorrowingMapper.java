package dev.nida.library.mapper;

/**
 * @author Nida Başer
 * May 2024
 */

import dev.nida.library.dto.request.BookBorrowingRequest;
import dev.nida.library.dto.request.BookBorrowingUpdateRequest;
import dev.nida.library.entity.BookBorrowing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface BookBorrowingMapper {

    BookBorrowing asEntity(BookBorrowingRequest bookBorrowingRequest);

    BookBorrowing asEntity(BookBorrowingUpdateRequest bookBorrowingUpdateRequest);

    void update(@MappingTarget BookBorrowing entity, BookBorrowingUpdateRequest bookBorrowingUpdateRequest);
}
