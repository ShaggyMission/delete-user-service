package com.mipagina.delete_user_service.service;

import com.mipagina.delete_user_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final WebClient webClient;

    public UserService(UserRepository userRepository, WebClient webClient) {
        this.userRepository = userRepository;
        this.webClient = webClient;
    }

    public void deleteUserById(String id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User with ID " + id + " not found");
        }

        userRepository.deleteById(id);

        webClient.delete()
                .uri("http://localhost:3001/roles/assign-role/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnSuccess(unused -> System.out.println("Role removed for user " + id))
                .doOnError(error -> System.err.println("Error removing role for user: " + error.getMessage()))
                .subscribe();
    }
}

