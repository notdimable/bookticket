package com.bookticket.app.api.users.repository;

import com.bookticket.app.api.users.model.entity.User;
import io.micrometer.common.lang.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(@NonNull Long id);
}
