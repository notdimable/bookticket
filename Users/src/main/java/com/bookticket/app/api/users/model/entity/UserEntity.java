package com.bookticket.app.api.users.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "First name must not be less than two characters")
    private String firstName;
    @NotNull
    @NotNull(message = "Second name cannot be null")
    @Size(min = 2, message = "Second name must not be less than two characters")
    private String secondName;
    @NotNull
    @NotNull(message = "Password cannot be null")
    @Size(min = 6, message = "Password must not be less than six characters")
    private String password;
    private int age;
    @Column(unique = true)
    @Email
    private String email;
    @Column(unique = true)
    private String phoneNumber;

}


