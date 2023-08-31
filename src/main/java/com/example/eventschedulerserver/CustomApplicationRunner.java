package com.example.eventschedulerserver;

import com.example.eventschedulerserver.repository.EventInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomApplicationRunner implements ApplicationRunner {

    private final EventInfo eventInfo;
    private final EventInfoRepository eventInfoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 전역 변수 값 설정
        log.info("ApplicationRunner");
        eventInfo.setEventMaxMember(eventInfoRepository.getMaxMember());
    }
}