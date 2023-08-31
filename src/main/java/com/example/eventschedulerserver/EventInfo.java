package com.example.eventschedulerserver;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Setter
@Getter
@Component
public class EventInfo {

    private Long eventMaxMember;
    private LocalDateTime closingTime;
}
