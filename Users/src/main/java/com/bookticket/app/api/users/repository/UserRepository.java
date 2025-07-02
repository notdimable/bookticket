package com.bookticket.app.api.users.repository;


import com.bookticket.app.api.users.model.entity.UserEntity;
import io.micrometer.common.lang.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(@NonNull Long id);

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);

    UserEntity findByEmail(String email);
}
