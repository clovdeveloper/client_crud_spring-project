package com.clovdev.spring_client_crud.client;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ClientRequestDTO(

        @NotEmpty
        @NotNull
        String name,
        @Email
        String email,
        @NotEmpty
        @NotNull
        String phone,
        String address
) {
}
