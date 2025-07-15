package com.bookticket.app.book.handler;

import com.bookticket.app.core.model.BookFlightCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;


@Component
@KafkaListener(topics = "flight-booked-event-topic", groupId = "flight-created-events")
public class BookFlightCreatedEventHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @KafkaHandler
    public void handle(BookFlightCreatedEvent flightCreatedEvent) {
        LOGGER.info("New event" + flightCreatedEvent.getFlightEventId());

    }
}
