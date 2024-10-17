package com.clovdev.spring_client_crud.mapper;


import com.clovdev.spring_client_crud.client.ClientRequestDTO;
import com.clovdev.spring_client_crud.client.ClientResponseDTO;
import com.clovdev.spring_client_crud.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper( ClientMapper.class );
    ClientResponseDTO entityToDto(Client client);
    Client dtoToEntity(ClientRequestDTO clientRequestDTO);
}
