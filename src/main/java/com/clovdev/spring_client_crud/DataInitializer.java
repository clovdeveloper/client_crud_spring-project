package com.clovdev.spring_client_crud;

import com.clovdev.spring_client_crud.entity.Client;
import com.clovdev.spring_client_crud.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer {

    @Bean
    public CommandLineRunner saveClient(ClientRepository clientRepository) {
        return args -> {
            var client = new Client();
            client.setName("clovdev");
            client.setEmail("clovdev@gmail.com");

            client.setPhone("+25761482930");
            client.setAddress("Buja-Ntahangwa");

          clientRepository.save(client);
            System.out.println(client.getName());
        };
    }
}
