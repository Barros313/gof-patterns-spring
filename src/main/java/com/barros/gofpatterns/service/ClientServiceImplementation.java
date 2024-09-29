package com.barros.gofpatterns.service;

import com.barros.gofpatterns.model.Address;
import com.barros.gofpatterns.model.AddressRepository;
import com.barros.gofpatterns.model.Client;
import com.barros.gofpatterns.model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImplementation implements ClientService {
    // Singleton: Inject Spring components as @Autowired
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implement methods into interface
    // Facade: Abstract API calls into simpler interface


    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        // FIXME: Adicionar exceção caso não ache o cliente
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void insert(Client client) {
        handleAddress(client);
    }

    @Override
    public void update(Long id, Client client) {
        // Verificar se este cliente existe
        Optional<Client> currentClient = clientRepository.findById(id);

        // Caso não existir, sair
        if (currentClient.isEmpty()) {
            // FIXME: Adicionar exceção caso não ache o cliente
            return;
        }

        client.setId(client.getId());

        // Verificar endereço
        handleAddress(client);
    }

    @Override
    public void delete(Long id) {

    }

    private void handleAddress(Client client) {
        // Verificar por endereço já cadastrado
        Optional<Address> currentAddress = addressRepository.findById(client.getAddress().getCep());

        // Caso já esteja cadastrado, atribuir endereço ao cliente e retornar
        if (currentAddress.isPresent()) {
            client.setAddress(currentAddress.get());
        } else {
            // Consumir dados da Api
            Address newAddress = viaCepService.findAddress(client.getAddress().getCep());

            // Salvar Endereço
            addressRepository.save(newAddress);

            // Atribuir novo endereço ao cliente
            client.setAddress(newAddress);
        }

        // Atualizar cliente
        clientRepository.save(client);
    }
}
