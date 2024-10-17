package com.clovdev.spring_client_crud.client;

import org.springframework.lang.NonNull;

public record ClientRequestDTO(
        @NonNull
        String name,
        @NonNull
        String email,
        String phone,
        String address
) {
}
