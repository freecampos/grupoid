package com.danielcampos.grupoid.dto;

import com.danielcampos.grupoid.models.Cliente;
import lombok.Data;

@Data
public class ClienteDevueltoDTO {
    private Boolean error;
    private Cliente dato;
    private String mensaje;

    public ClienteDevueltoDTO(Boolean e, Cliente dato, String mensaje){
        this.error = e;
        this.dato = dato;
        this.mensaje = mensaje;
    }
}
