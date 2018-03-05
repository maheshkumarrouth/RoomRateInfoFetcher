package de.cultuzz.roomrateinfofetcher.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "de.cultuzz.roomrateinfofetcher")
@EntityScan( basePackages = {"de.cultuzz.roomrateinfofetcher.model"} )
@EnableJpaRepositories(basePackages={"de.cultuzz.roomrateinfofetcher"})
@EnableCaching
public class ApplicationStarter {

	public static void main(String args[]) {
		SpringApplication.run(ApplicationStarter.class, args);
	}	

}
