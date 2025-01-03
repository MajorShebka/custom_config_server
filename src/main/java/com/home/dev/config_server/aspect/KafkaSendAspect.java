package com.home.dev.config_server.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.dev.config_server.service.model.Property;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class KafkaSendAspect {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @After("@annotation(kafkaSend)")
    public void sendMessage(JoinPoint joinPoint, KafkaSend kafkaSend) {
        Property property = (Property) joinPoint.getArgs()[0];
        String topic = property.getServiceName().split("\\.")[0];
        String propertyJson = objectMapper.writeValueAsString(property);
        kafkaTemplate.send(topic, propertyJson);
    }
}
