package study.jpa_entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import study.jpa_entity.domain.Member;

@SpringBootApplication
@EnableJpaAuditing
public class JpaEntityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEntityApplication.class, args);
    }

}
