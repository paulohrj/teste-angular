package br.com.provaangular.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.provaangular.domain.Cliente;
import br.com.provaangular.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente findById(UUID id) {
        return clienteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public void deleteById(UUID id) {
        clienteRepository.deleteById(id);
    }

}
