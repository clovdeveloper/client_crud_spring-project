package com.clovdev.spring_client_crud.client;

public record ClientResponseDTO(
        Long id,
        String name,
        String email,
        String phone,
        String address
) {
}
