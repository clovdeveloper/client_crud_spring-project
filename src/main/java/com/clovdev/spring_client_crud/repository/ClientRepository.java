package com.clovdev.spring_client_crud.repository;


import com.clovdev.spring_client_crud.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface ClientRepository extends CrudRepository<Client, Long> {


  //Set<Client> findAll();
  Page<Client> findAll(Pageable pageable);

  }
