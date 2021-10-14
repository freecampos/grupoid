package com.danielcampos.grupoid.service;

import com.danielcampos.grupoid.dto.ClienteDevueltoNoIdDTO;
import com.danielcampos.grupoid.models.Cliente;
import com.danielcampos.grupoid.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        System.out.println("servicio");
        if(clienteRepository.findAll() != null)
            System.out.println("Valido");
        return clienteRepository.findAll();
    }

    public Cliente save(ClienteDevueltoNoIdDTO clienteDevueltoNoIdDTO) {
        Cliente cliente = new Cliente(
                null,
                clienteDevueltoNoIdDTO.getNombre(),
                clienteDevueltoNoIdDTO.getTlf());
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
