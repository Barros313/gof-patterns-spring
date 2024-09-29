package com.barros.gofpatterns.service;

import com.barros.gofpatterns.model.Client;

public interface ClientService {
    Iterable<Client> findAll();

    Client findById(Long id);

    void insert(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}
