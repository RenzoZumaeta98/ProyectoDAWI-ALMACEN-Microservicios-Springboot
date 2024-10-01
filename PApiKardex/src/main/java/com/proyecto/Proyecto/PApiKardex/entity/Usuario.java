
package com.proyecto.Proyecto.PApiKardex.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Usuario {
    private Long id;
    private String nombreUsu;
    private String apellidoUsu;
    private String telefonoUsu;
    private String codigoUsu;
    
}
