package dev.nida.library.mapper;

/**
 * @author Nida Başer
 * May 2024
 */

import dev.nida.library.dto.response.PublisherResponse;
import dev.nida.library.entity.Publisher;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface PublisherMapper {
    PublisherResponse asOutput(Publisher publisher);

    List<PublisherResponse> asOutput(List<Publisher> publishers);
}

