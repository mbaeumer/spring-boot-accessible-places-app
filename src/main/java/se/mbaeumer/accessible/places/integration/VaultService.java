package se.mbaeumer.accessible.places.integration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
//@Profile("test")
public class VaultService {
    @Value("${places.api.key}")
    private String mySecret;

    @PostConstruct
    public void printSecret() {
        System.out.println("The secret is: " + mySecret);
    }

    public String getVault(){
        return mySecret;
    }
}
