package com.rfb.repository;

import com.rfb.domain.RfbLocation;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the RfbLocation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RfbLocationRepository extends JpaRepository<RfbLocation, Long> {
    List<RfbLocation> findAllByRunDayOfWeek(int dayOfWeek);

    RfbLocation findByLocationName(String name);
}
