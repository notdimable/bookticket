package com.bookticket.app.api.admin.repository;


import com.bookticket.app.core.model.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
    FlightEntity findByFlightNumber(String flightNumber);
    boolean existsByFlightNumber(String flightNumber);
}
