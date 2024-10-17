package com.clovdev.spring_client_crud.mapper;

import com.clovdev.clientcrud.dto.client.ClientRequestDTO;
import com.clovdev.clientcrud.dto.client.ClientResponseDTO;
import com.clovdev.clientcrud.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper( ClientMapper.class );
    ClientResponseDTO entityToDto(Client client);
    Client dtoToEntity(ClientRequestDTO clientRequestDTO);
}
