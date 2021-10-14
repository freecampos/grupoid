package com.danielcampos.grupoid.dto;

import com.danielcampos.grupoid.models.Cliente;
import lombok.Data;

import java.util.List;

@Data
public class ClienteEnviadoDTO {
    private Boolean error;
    private List<Cliente> dato;
    private String mensaje;

    public ClienteEnviadoDTO(Boolean e, List<Cliente> listado, String mensaje){
        this.error = e;
        this.dato = listado;
        this.mensaje = mensaje;
    }
}
