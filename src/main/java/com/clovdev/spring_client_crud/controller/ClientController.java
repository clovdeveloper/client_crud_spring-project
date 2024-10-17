package com.clovdev.spring_client_crud.controller;

import com.clovdev.spring_client_crud.client.ClientRequestDTO;
import com.clovdev.spring_client_crud.client.ClientResponseDTO;
import com.clovdev.spring_client_crud.mapper.ClientMapper;
import com.clovdev.spring_client_crud.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
    ResponseEntity<ClientResponseDTO> create(@RequestBody ClientRequestDTO clientRequestDTO) {
        var createdClient = clientService.save(clientRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    @GetMapping("/{clientId}")
    ResponseEntity<ClientResponseDTO> findById(@PathVariable Long clientId) {
        var client= clientService.findById(clientId);
        return ResponseEntity.ok(clientMapper.entityToDto(client));
    }
    @GetMapping
    ResponseEntity<Set<ClientResponseDTO>> findAll() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @DeleteMapping("/{clientId}")
    ResponseEntity<ClientResponseDTO> delete(@PathVariable Long clientId) {
        clientService.delete(clientId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{clientId}")
    ResponseEntity<ClientResponseDTO> update(@RequestBody ClientRequestDTO clientRequestDTO, @PathVariable Long clientId) {;
        return ResponseEntity.ok(clientService.update(clientRequestDTO, clientId));
    }



}
