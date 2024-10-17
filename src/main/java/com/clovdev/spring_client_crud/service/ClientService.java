package com.clovdev.spring_client_crud.service;




import com.clovdev.spring_client_crud.client.ClientRequestDTO;
import com.clovdev.spring_client_crud.client.ClientResponseDTO;
import com.clovdev.spring_client_crud.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

    ClientResponseDTO save(ClientRequestDTO clientRequestDTO);
    void  update(ClientRequestDTO clientRequestDTO,Long id);
    void  delete(Long id);
    Client findById(Long id);
     Page<ClientResponseDTO> findAll(Pageable pageable);
}
