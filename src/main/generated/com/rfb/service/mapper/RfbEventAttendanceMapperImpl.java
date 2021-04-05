package com.rfb.service.mapper;

import com.rfb.domain.RfbEventAttendance;
import com.rfb.service.dto.RfbEventAttendanceDTO;
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
public class RfbEventAttendanceMapperImpl implements RfbEventAttendanceMapper {

    @Autowired
    private RfbEventMapper rfbEventMapper;
    @Autowired
    private RfbUserMapper rfbUserMapper;

    @Override
    public RfbEventAttendance toEntity(RfbEventAttendanceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RfbEventAttendance rfbEventAttendance = new RfbEventAttendance();

        rfbEventAttendance.id( dto.getId() );
        rfbEventAttendance.setAttendanceDate( dto.getAttendanceDate() );
        rfbEventAttendance.setRfbEvent( rfbEventMapper.toEntity( dto.getRfbEvent() ) );
        rfbEventAttendance.setRfbUser( rfbUserMapper.toEntity( dto.getRfbUser() ) );

        return rfbEventAttendance;
    }

    @Override
    public List<RfbEventAttendance> toEntity(List<RfbEventAttendanceDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RfbEventAttendance> list = new ArrayList<RfbEventAttendance>( dtoList.size() );
        for ( RfbEventAttendanceDTO rfbEventAttendanceDTO : dtoList ) {
            list.add( toEntity( rfbEventAttendanceDTO ) );
        }

        return list;
    }

    @Override
    public List<RfbEventAttendanceDTO> toDto(List<RfbEventAttendance> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RfbEventAttendanceDTO> list = new ArrayList<RfbEventAttendanceDTO>( entityList.size() );
        for ( RfbEventAttendance rfbEventAttendance : entityList ) {
            list.add( toDto( rfbEventAttendance ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(RfbEventAttendance entity, RfbEventAttendanceDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.id( dto.getId() );
        }
        if ( dto.getAttendanceDate() != null ) {
            entity.setAttendanceDate( dto.getAttendanceDate() );
        }
        if ( dto.getRfbEvent() != null ) {
            entity.setRfbEvent( rfbEventMapper.toEntity( dto.getRfbEvent() ) );
        }
        if ( dto.getRfbUser() != null ) {
            entity.setRfbUser( rfbUserMapper.toEntity( dto.getRfbUser() ) );
        }
    }

    @Override
    public RfbEventAttendanceDTO toDto(RfbEventAttendance s) {
        if ( s == null ) {
            return null;
        }

        RfbEventAttendanceDTO rfbEventAttendanceDTO = new RfbEventAttendanceDTO();

        rfbEventAttendanceDTO.setRfbEvent( rfbEventMapper.toDtoId( s.getRfbEvent() ) );
        rfbEventAttendanceDTO.setRfbUser( rfbUserMapper.toDtoId( s.getRfbUser() ) );
        rfbEventAttendanceDTO.setId( s.getId() );
        rfbEventAttendanceDTO.setAttendanceDate( s.getAttendanceDate() );

        return rfbEventAttendanceDTO;
    }
}
