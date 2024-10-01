
package com.proyecto.Proyecto.PApiUsuario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreUsu;
    private String apellidoUsu;
    private String telefonoUsu;
    private String codigoUsu;
    
    
}
