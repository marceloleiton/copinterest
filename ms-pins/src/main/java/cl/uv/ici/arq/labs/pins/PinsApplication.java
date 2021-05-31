package cl.uv.ici.arq.labs.pins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ConfigurationProperties
@PropertySources({
        @PropertySource("classpath:config.properties"),
        @PropertySource("classpath:database.properties") 
})
public class PinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinsApplication.class, args);
	}

}
