package com.rfb.service.mapper;

import com.rfb.domain.RfbEvent;
import com.rfb.service.dto.RfbEventDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-05T00:21:55-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
@Component
public class RfbEventMapperImpl implements RfbEventMapper {

    @Autowired
    private RfbLocationMapper rfbLocationMapper;

    @Override
    public RfbEvent toEntity(RfbEventDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RfbEvent rfbEvent = new RfbEvent();

        rfbEvent.id( dto.getId() );
        rfbEvent.setEventDate( dto.getEventDate() );
        rfbEvent.setEventCode( dto.getEventCode() );
        rfbEvent.setRfbLocation( rfbLocationMapper.toEntity( dto.getRfbLocation() ) );

        return rfbEvent;
    }

    @Override
    public List<RfbEvent> toEntity(List<RfbEventDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RfbEvent> list = new ArrayList<RfbEvent>( dtoList.size() );
        for ( RfbEventDTO rfbEventDTO : dtoList ) {
            list.add( toEntity( rfbEventDTO ) );
        }

        return list;
    }

    @Override
    public List<RfbEventDTO> toDto(List<RfbEvent> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RfbEventDTO> list = new ArrayList<RfbEventDTO>( entityList.size() );
        for ( RfbEvent rfbEvent : entityList ) {
            list.add( toDto( rfbEvent ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(RfbEvent entity, RfbEventDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.id( dto.getId() );
        }
        if ( dto.getEventDate() != null ) {
            entity.setEventDate( dto.getEventDate() );
        }
        if ( dto.getEventCode() != null ) {
            entity.setEventCode( dto.getEventCode() );
        }
        if ( dto.getRfbLocation() != null ) {
            entity.setRfbLocation( rfbLocationMapper.toEntity( dto.getRfbLocation() ) );
        }
    }

    @Override
    public RfbEventDTO toDto(RfbEvent s) {
        if ( s == null ) {
            return null;
        }

        RfbEventDTO rfbEventDTO = new RfbEventDTO();

        rfbEventDTO.setRfbLocation( rfbLocationMapper.toDtoId( s.getRfbLocation() ) );
        rfbEventDTO.setId( s.getId() );
        rfbEventDTO.setEventDate( s.getEventDate() );
        rfbEventDTO.setEventCode( s.getEventCode() );

        return rfbEventDTO;
    }

    @Override
    public RfbEventDTO toDtoId(RfbEvent rfbEvent) {
        if ( rfbEvent == null ) {
            return null;
        }

        RfbEventDTO rfbEventDTO = new RfbEventDTO();

        rfbEventDTO.setId( rfbEvent.getId() );

        return rfbEventDTO;
    }
}
