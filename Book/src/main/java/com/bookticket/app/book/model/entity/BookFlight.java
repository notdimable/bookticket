package com.bookticket.app.book.model.entity;


import com.bookticket.app.core.model.ServiceClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookFlight {
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String userPhone;
    @Id
    private String flightNumber;
    @Column(nullable = false)
    private ServiceClass serviceClass;
}
