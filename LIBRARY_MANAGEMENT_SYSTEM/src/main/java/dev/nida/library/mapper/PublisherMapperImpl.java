package dev.nida.library.mapper;

/**
 * @author Nida Başer
 * May 2024
 */

import dev.nida.library.dto.response.PublisherResponse;
import dev.nida.library.entity.Publisher;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class PublisherMapperImpl implements PublisherMapper {

    @Override
    public PublisherResponse asOutput(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherResponse publisherResponse = new PublisherResponse();

        publisherResponse.setId( publisher.getId() );
        publisherResponse.setName( publisher.getName() );
        publisherResponse.setEstablishmentYear( publisher.getEstablishmentYear() );

        return publisherResponse;
    }

    @Override
    public List<PublisherResponse> asOutput(List<Publisher> publishers) {
        if ( publishers == null ) {
            return null;
        }

        List<PublisherResponse> list = new ArrayList<PublisherResponse>( publishers.size() );
        for ( Publisher publisher : publishers ) {
            list.add( asOutput( publisher ) );
        }

        return list;
    }
}