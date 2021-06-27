package app.web.pavelk.database5.back2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Back2 {

    public static void main(String[] args) {
        SpringApplication.run(Back2.class, args);
    }

}
