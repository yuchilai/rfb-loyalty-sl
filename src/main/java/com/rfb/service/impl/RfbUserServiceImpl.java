package com.rfb.service.impl;

import com.rfb.domain.RfbUser;
import com.rfb.repository.RfbUserRepository;
import com.rfb.service.RfbUserService;
import com.rfb.service.dto.RfbUserDTO;
import com.rfb.service.mapper.RfbUserMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link RfbUser}.
 */
@Service
@Transactional
public class RfbUserServiceImpl implements RfbUserService {

    private final Logger log = LoggerFactory.getLogger(RfbUserServiceImpl.class);

    private final RfbUserRepository rfbUserRepository;

    private final RfbUserMapper rfbUserMapper;

    public RfbUserServiceImpl(RfbUserRepository rfbUserRepository, RfbUserMapper rfbUserMapper) {
        this.rfbUserRepository = rfbUserRepository;
        this.rfbUserMapper = rfbUserMapper;
    }

    @Override
    public RfbUserDTO save(RfbUserDTO rfbUserDTO) {
        log.debug("Request to save RfbUser : {}", rfbUserDTO);
        RfbUser rfbUser = rfbUserMapper.toEntity(rfbUserDTO);
        rfbUser = rfbUserRepository.save(rfbUser);
        return rfbUserMapper.toDto(rfbUser);
    }

    @Override
    public Optional<RfbUserDTO> partialUpdate(RfbUserDTO rfbUserDTO) {
        log.debug("Request to partially update RfbUser : {}", rfbUserDTO);

        return rfbUserRepository
            .findById(rfbUserDTO.getId())
            .map(
                existingRfbUser -> {
                    rfbUserMapper.partialUpdate(existingRfbUser, rfbUserDTO);
                    return existingRfbUser;
                }
            )
            .map(rfbUserRepository::save)
            .map(rfbUserMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RfbUserDTO> findAll() {
        log.debug("Request to get all RfbUsers");
        return rfbUserRepository.findAll().stream().map(rfbUserMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RfbUserDTO> findOne(Long id) {
        log.debug("Request to get RfbUser : {}", id);
        return rfbUserRepository.findById(id).map(rfbUserMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RfbUser : {}", id);
        rfbUserRepository.deleteById(id);
    }
}
