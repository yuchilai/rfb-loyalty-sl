package com.rfb.service.mapper;

import com.rfb.domain.RfbUser;
import com.rfb.service.dto.RfbUserDTO;
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
public class RfbUserMapperImpl implements RfbUserMapper {

    @Autowired
    private RfbLocationMapper rfbLocationMapper;

    @Override
    public RfbUser toEntity(RfbUserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RfbUser rfbUser = new RfbUser();

        rfbUser.id( dto.getId() );
        rfbUser.setUsername( dto.getUsername() );
        rfbUser.setHomeLocation( rfbLocationMapper.toEntity( dto.getHomeLocation() ) );

        return rfbUser;
    }

    @Override
    public List<RfbUser> toEntity(List<RfbUserDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RfbUser> list = new ArrayList<RfbUser>( dtoList.size() );
        for ( RfbUserDTO rfbUserDTO : dtoList ) {
            list.add( toEntity( rfbUserDTO ) );
        }

        return list;
    }

    @Override
    public List<RfbUserDTO> toDto(List<RfbUser> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RfbUserDTO> list = new ArrayList<RfbUserDTO>( entityList.size() );
        for ( RfbUser rfbUser : entityList ) {
            list.add( toDto( rfbUser ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(RfbUser entity, RfbUserDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.id( dto.getId() );
        }
        if ( dto.getUsername() != null ) {
            entity.setUsername( dto.getUsername() );
        }
        if ( dto.getHomeLocation() != null ) {
            entity.setHomeLocation( rfbLocationMapper.toEntity( dto.getHomeLocation() ) );
        }
    }

    @Override
    public RfbUserDTO toDto(RfbUser s) {
        if ( s == null ) {
            return null;
        }

        RfbUserDTO rfbUserDTO = new RfbUserDTO();

        rfbUserDTO.setHomeLocation( rfbLocationMapper.toDtoId( s.getHomeLocation() ) );
        rfbUserDTO.setId( s.getId() );
        rfbUserDTO.setUsername( s.getUsername() );

        return rfbUserDTO;
    }

    @Override
    public RfbUserDTO toDtoId(RfbUser rfbUser) {
        if ( rfbUser == null ) {
            return null;
        }

        RfbUserDTO rfbUserDTO = new RfbUserDTO();

        rfbUserDTO.setId( rfbUser.getId() );

        return rfbUserDTO;
    }
}
