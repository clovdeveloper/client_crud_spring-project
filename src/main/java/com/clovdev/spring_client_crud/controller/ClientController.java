package com.clovdev.spring_client_crud.controller;

import com.clovdev.spring_client_crud.client.ClientRequestDTO;
import com.clovdev.spring_client_crud.client.ClientResponseDTO;
import com.clovdev.spring_client_crud.mapper.ClientMapper;
import com.clovdev.spring_client_crud.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @PostMapping
    ResponseEntity<ClientResponseDTO> create(@RequestBody @Valid ClientRequestDTO clientRequestDTO) {
        var createdClient = clientService.save(clientRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    @GetMapping("/{clientId}")
    ResponseEntity<ClientResponseDTO> findById(@PathVariable Long clientId) {
        var client= clientService.findById(clientId);
        return ResponseEntity.ok(clientMapper.entityToDto(client));
    }
    @GetMapping
    ResponseEntity<Page<ClientResponseDTO>> findAll(@RequestParam Optional<Integer> page,Optional<Integer> size) {

        return ResponseEntity.ok(clientService.findAll(PageRequest.of(page.orElse(0), size.orElse(10))));
    }

    @DeleteMapping("/{clientId}")
    ResponseEntity<ClientResponseDTO> delete(@PathVariable Long clientId) {
        clientService.delete(clientId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{clientId}")
    ResponseEntity<Void> update(@RequestBody ClientRequestDTO clientRequestDTO, @PathVariable Long clientId) {
        clientService.update(clientRequestDTO, clientId);
        return ResponseEntity.ok(null);
    }



}
