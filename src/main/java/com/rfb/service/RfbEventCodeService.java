package com.rfb.service;

import com.rfb.domain.RfbEvent;
import com.rfb.domain.RfbLocation;
import com.rfb.repository.RfbEventRepository;
import com.rfb.repository.RfbLocationRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Service
public class RfbEventCodeService {
    private final Logger log = LoggerFactory.getLogger(RfbEventCodeService.class);

    private final RfbLocationRepository rfbLocationRepository;
    private final RfbEventRepository rfbEventRepository;

    public RfbEventCodeService(RfbLocationRepository rfbLocationRepository, RfbEventRepository rfbEventRepository) {
        this.rfbLocationRepository = rfbLocationRepository;
        this.rfbEventRepository = rfbEventRepository;
    }

    /**
     * 0 0 * * * * = the top of every hour of every day
     * 0 0 8-10 * * * = 8, 9 and 10 o'clock of every day.
     * 0 0 6,19 * * * = 6:00 AM and 7:00 PM every day.
     * 0 0 9-17 * * MON-FRI = on the hour nine-to-five weekdays
     * 0 0 0 25 12 ? = every Christmas Day at midnight
     */
    @Scheduled(cron = "0 0 * * * ?") // run once per hour, at top of hour
//    @Scheduled(cron = "0 * * * * ?") // run once per min
//    @Scheduled(cron = "* * * * * ?") // run once per sec
    public void generateRunEventCodes(){

        log.debug("Generating Events");

        List<RfbLocation> rfbLocations = rfbLocationRepository.findAllByRunDayOfWeek(LocalDate.now().getDayOfWeek().getValue());

        log.debug("Locations Found for Events: " + rfbLocations.size());

        rfbLocations.forEach(location -> {
            log.debug("Checking Events for location: " + location.getId());

            RfbEvent existingEvent = rfbEventRepository.findByRfbLocationAndEventDate(location, LocalDate.now());

            if(existingEvent == null){
                log.debug("Event Not Found, Creating Event");

                RfbEvent newEvent = new RfbEvent();
                newEvent.setRfbLocation(location);
                newEvent.setEventDate(LocalDate.now());
                newEvent.setEventCode(RandomStringUtils.randomAlphabetic(10).toUpperCase());

                rfbEventRepository.save(newEvent);

                log.debug("Created Event: " + newEvent.toString());
            }
            else {
                log.debug("Event exists for day");
            }
        });
    }
}
