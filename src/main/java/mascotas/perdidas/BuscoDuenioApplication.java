package mascotas.perdidas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

@SpringBootApplication
public class BuscoDuenioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuscoDuenioApplication.class, args);
	}

}
