package com.clovdev.spring_client_crud.service;




import com.clovdev.spring_client_crud.client.ClientRequestDTO;
import com.clovdev.spring_client_crud.client.ClientResponseDTO;
import com.clovdev.spring_client_crud.entity.Client;

import java.util.Set;

public interface ClientService {

    ClientResponseDTO save(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO  update(ClientRequestDTO clientRequestDTO,Long id);
    void  delete(Long id);
    Client findById(Long id);
    Set<ClientResponseDTO> getAll();


}
