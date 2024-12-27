package se.mbaeumer.accessible.places;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AccessiblePlacesApp {
    public static void main(String[] args) {
        SpringApplication.run(AccessiblePlacesApp.class, args);
    }
}
