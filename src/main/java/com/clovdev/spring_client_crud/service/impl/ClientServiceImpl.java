package com.clovdev.spring_client_crud.service.impl;


import com.clovdev.spring_client_crud.client.ClientRequestDTO;
import com.clovdev.spring_client_crud.client.ClientResponseDTO;
import com.clovdev.spring_client_crud.entity.Client;
import com.clovdev.spring_client_crud.mapper.ClientMapper;
import com.clovdev.spring_client_crud.repository.ClientRepository;
import com.clovdev.spring_client_crud.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }


    @Override
    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        var savedClient = clientRepository.save(clientMapper.dtoToEntity(clientRequestDTO));
        return clientMapper.entityToDto(savedClient);
    }

    @Override
    public ClientResponseDTO update(ClientRequestDTO clientRequestDTO, Long id) {
        var clientToUpdate = findById(id);
        BeanUtils.copyProperties(clientRequestDTO, clientToUpdate);
        return clientMapper.entityToDto(clientRepository.save(clientToUpdate));

    }

    @Override
    public void delete(Long id) {
        findById(id);
        clientRepository.deleteById(id);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(()->
                new NoSuchElementException(format("Client not found with id %d", id)));
    }

    @Override
    public Set<ClientResponseDTO> getAll() {
        Set<Client> clients = clientRepository.findAll();
        return clients.stream().map(clientMapper::entityToDto).collect(Collectors.toSet()) ;
    }
}
