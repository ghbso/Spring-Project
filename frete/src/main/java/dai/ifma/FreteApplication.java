package dai.ifma;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication

@EntityScan(basePackages="dai.ifma.model")
@ComponentScan(basePackages={"dai.ifma.controller", "dai.ifma.service"})
@EnableJpaRepositories("dai.ifma.repository")

public class FreteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreteApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}	
	
	
}
