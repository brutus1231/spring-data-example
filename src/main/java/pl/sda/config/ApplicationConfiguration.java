package pl.sda.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("pl.sda")
@EnableJpaRepositories("pl.sda.repository")
public class ApplicationConfiguration {

}
