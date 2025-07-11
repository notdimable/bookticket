package com.bookticket.app.book.repository;

import com.bookticket.app.book.model.entity.BookFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookFlight, Long> {
}
