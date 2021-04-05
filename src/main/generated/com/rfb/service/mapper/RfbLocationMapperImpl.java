package com.rfb.service.mapper;

import com.rfb.domain.RfbLocation;
import com.rfb.service.dto.RfbLocationDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-05T00:21:55-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
@Component
public class RfbLocationMapperImpl implements RfbLocationMapper {

    @Override
    public RfbLocation toEntity(RfbLocationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RfbLocation rfbLocation = new RfbLocation();

        rfbLocation.id( dto.getId() );
        rfbLocation.setLocationName( dto.getLocationName() );
        rfbLocation.setRunDayOfWeek( dto.getRunDayOfWeek() );

        return rfbLocation;
    }

    @Override
    public RfbLocationDTO toDto(RfbLocation entity) {
        if ( entity == null ) {
            return null;
        }

        RfbLocationDTO rfbLocationDTO = new RfbLocationDTO();

        rfbLocationDTO.setId( entity.getId() );
        rfbLocationDTO.setLocationName( entity.getLocationName() );
        rfbLocationDTO.setRunDayOfWeek( entity.getRunDayOfWeek() );

        return rfbLocationDTO;
    }

    @Override
    public List<RfbLocation> toEntity(List<RfbLocationDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RfbLocation> list = new ArrayList<RfbLocation>( dtoList.size() );
        for ( RfbLocationDTO rfbLocationDTO : dtoList ) {
            list.add( toEntity( rfbLocationDTO ) );
        }

        return list;
    }

    @Override
    public List<RfbLocationDTO> toDto(List<RfbLocation> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RfbLocationDTO> list = new ArrayList<RfbLocationDTO>( entityList.size() );
        for ( RfbLocation rfbLocation : entityList ) {
            list.add( toDto( rfbLocation ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(RfbLocation entity, RfbLocationDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.id( dto.getId() );
        }
        if ( dto.getLocationName() != null ) {
            entity.setLocationName( dto.getLocationName() );
        }
        if ( dto.getRunDayOfWeek() != null ) {
            entity.setRunDayOfWeek( dto.getRunDayOfWeek() );
        }
    }

    @Override
    public RfbLocationDTO toDtoId(RfbLocation rfbLocation) {
        if ( rfbLocation == null ) {
            return null;
        }

        RfbLocationDTO rfbLocationDTO = new RfbLocationDTO();

        rfbLocationDTO.setId( rfbLocation.getId() );

        return rfbLocationDTO;
    }
}
