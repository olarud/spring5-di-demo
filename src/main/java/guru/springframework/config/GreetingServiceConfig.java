package guru.springframework.config;

import guru.springframework.services.GreetingRepository;
import guru.springframework.services.GreetingService;
import guru.springframework.services.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    public GreetingServiceFactory greetingServiceFactory(GreetingRepository greetingRepository) {
        return new GreetingServiceFactory(greetingRepository);
    }

    @Bean
    @Profile({"en", "default"})
    @Primary
    public GreetingService primaryGreetingService(GreetingRepository greetingRepository) {
        return greetingServiceFactory(greetingRepository).createGreetingService("en");
    }

    @Bean
    @Profile("es")
    @Primary
    public GreetingService primarySpanishGreetingService(GreetingRepository greetingRepository) {
        return greetingServiceFactory(greetingRepository).createGreetingService("es");
    }

    @Bean
    @Profile("de")
    @Primary
    public GreetingService primaryGermanGreetingService(GreetingRepository greetingRepository) {
        return greetingServiceFactory(greetingRepository).createGreetingService("de");
    }
}


