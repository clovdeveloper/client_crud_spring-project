package com.clovdev.spring_client_crud.client;

import java.time.LocalDateTime;

public record ClientResponseDTO(
        Long id,
        String name,
        String email,
        String phone,
        String address,
        LocalDateTime createdAt
) {
}
