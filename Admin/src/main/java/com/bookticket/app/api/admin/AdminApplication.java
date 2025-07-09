package com.bookticket.app.api.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.bookticket.app.api.admin", "com.bookticket.app.core"})
@EntityScan("com.bookticket.app.core.model")
@EnableJpaRepositories("com.bookticket.app.api.admin.repository")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
