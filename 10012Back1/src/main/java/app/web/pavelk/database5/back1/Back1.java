package app.web.pavelk.database5.back1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Back1 {

	public static void main(String[] args) {
		SpringApplication.run(Back1.class, args);
	}

}
