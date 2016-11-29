package iwm2016.telemd;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TeleMdApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeleMdApplication.class, args);
	}

}
