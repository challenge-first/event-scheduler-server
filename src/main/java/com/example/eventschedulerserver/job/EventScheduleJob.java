package com.example.eventschedulerserver.job;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Slf4j
@RequiredArgsConstructor
@Component
@EnableSchedulerLock(defaultLockAtMostFor = "PT1S")
public class EventScheduleJob {

    private final JobDetails jobDetails;

    @Scheduled(cron = "0/1 * * * * *")
    @SchedulerLock(name = "event-scheduler", lockAtMostFor = "PT1S", lockAtLeastFor = "PT1S")
    public void eventSchedule() throws JsonProcessingException {
        log.info("scheduler running");
        jobDetails.transferWinner();
    }
}
