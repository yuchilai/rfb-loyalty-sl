package com.rfb.service.impl;

import com.rfb.domain.RfbEvent;
import com.rfb.repository.RfbEventRepository;
import com.rfb.service.RfbEventService;
import com.rfb.service.dto.RfbEventDTO;
import com.rfb.service.mapper.RfbEventMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link RfbEvent}.
 */
@Service
@Transactional
public class RfbEventServiceImpl implements RfbEventService {

    private final Logger log = LoggerFactory.getLogger(RfbEventServiceImpl.class);

    private final RfbEventRepository rfbEventRepository;

    private final RfbEventMapper rfbEventMapper;

    public RfbEventServiceImpl(RfbEventRepository rfbEventRepository, RfbEventMapper rfbEventMapper) {
        this.rfbEventRepository = rfbEventRepository;
        this.rfbEventMapper = rfbEventMapper;
    }

    @Override
    public RfbEventDTO save(RfbEventDTO rfbEventDTO) {
        log.debug("Request to save RfbEvent : {}", rfbEventDTO);
        RfbEvent rfbEvent = rfbEventMapper.toEntity(rfbEventDTO);
        rfbEvent = rfbEventRepository.save(rfbEvent);
        return rfbEventMapper.toDto(rfbEvent);
    }

    @Override
    public Optional<RfbEventDTO> partialUpdate(RfbEventDTO rfbEventDTO) {
        log.debug("Request to partially update RfbEvent : {}", rfbEventDTO);

        return rfbEventRepository
            .findById(rfbEventDTO.getId())
            .map(
                existingRfbEvent -> {
                    rfbEventMapper.partialUpdate(existingRfbEvent, rfbEventDTO);
                    return existingRfbEvent;
                }
            )
            .map(rfbEventRepository::save)
            .map(rfbEventMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RfbEventDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RfbEvents");
        return rfbEventRepository.findAll(pageable).map(rfbEventMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RfbEventDTO> findOne(Long id) {
        log.debug("Request to get RfbEvent : {}", id);
        return rfbEventRepository.findById(id).map(rfbEventMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RfbEvent : {}", id);
        rfbEventRepository.deleteById(id);
    }
}
