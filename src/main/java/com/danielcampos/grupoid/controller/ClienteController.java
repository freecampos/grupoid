package com.danielcampos.grupoid.controller;

import com.danielcampos.grupoid.service.ClienteService;
import com.danielcampos.grupoid.dto.ClienteDevueltoDTO;
import com.danielcampos.grupoid.dto.ClienteDevueltoNoIdDTO;
import com.danielcampos.grupoid.dto.DatosClienteDTO;
import com.danielcampos.grupoid.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/api/clientes")
    public DatosClienteDTO getTodosClientes(){
        List<Cliente> listado = clienteService.findAll();
        if (listado == null){
            System.out.println("nulo");
            return new DatosClienteDTO(true, null, "Error");
        }
        return new DatosClienteDTO(false, listado, "");
    }

    @PostMapping("/api/clientes")
    public ClienteDevueltoDTO postCliente(@RequestBody @Valid ClienteDevueltoNoIdDTO clienteDevueltoNoIdDTO){
        Cliente cliente = clienteService.save(clienteDevueltoNoIdDTO);
        if (cliente == null){
            return new ClienteDevueltoDTO(true, null, "Error al añadir");
        }
        return new ClienteDevueltoDTO(false, cliente, "");
    }
    @GetMapping("/api/clientes/{id}")
    public ClienteDevueltoDTO getByID(@PathVariable Long id){
        try {
            Cliente cliente= clienteService.findById(id).get();
            return new ClienteDevueltoDTO(false,cliente, "");
        }catch (NoSuchElementException e){
            return new ClienteDevueltoDTO(true, null, "Cliente no encontrado");
        }
    }

    @PutMapping("/api/clientes/{id}")
    public ClienteDevueltoDTO updateById(
            @PathVariable Long id,
            @RequestBody @Valid Cliente clienteModificar){
        try {
            Cliente cliente= clienteService.findById(id).get();
            cliente.setTlf(clienteModificar.getTlf());
            cliente.setNombre(clienteModificar.getNombre());
            clienteService.update(cliente);
            return new ClienteDevueltoDTO(false,cliente, "");
        }catch (NoSuchElementException e){
            return new ClienteDevueltoDTO(true, null, "Cliente no encontrado");
        }
    }
    @DeleteMapping("/api/clientes/{id}")
    public ClienteDevueltoDTO deleteByID(@PathVariable Long id){
        try {
            Cliente ret= clienteService.findById(id).get();
            clienteService.deleteById(id);
            return new ClienteDevueltoDTO(false,ret, "");
        }catch (NoSuchElementException e){
            return new ClienteDevueltoDTO(true, null, "Cliente no encontrado");
        }
    }
}
