package com.example.eventschedulerserver.job;

import com.example.eventschedulerserver.adapter.producer.KafkaProducer;
import com.example.eventschedulerserver.dto.RequestCouponMessage;
import com.example.eventschedulerserver.repository.RedisRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class JobDetails {

    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper;
    private final RedisRepository redisRepository;

    public void transferWinner() {
        try {

//            Set<String> set1 = redisRepository.zRange(String.valueOf(1L), 10L);
//            for (String s : set1) {
//                log.info("zRange = {}", s);
//            }

            Set<String> strings = redisRepository.zPopMin(String.valueOf(1L), 10L);
            for (String string : strings) {
                log.info("zPopMin = {}", string);
                RequestCouponMessage requestCouponMessage = new RequestCouponMessage(1L, Long.parseLong(string));
                kafkaProducer.sendEventMessage("coupon-topic", objectMapper.writeValueAsString(requestCouponMessage));
            }
        } catch (Exception e) {
            log.error("An error occurred during transferWinner: {}", e.getMessage(), e);
        }
    }
}
