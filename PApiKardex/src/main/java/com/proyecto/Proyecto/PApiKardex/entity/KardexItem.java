
package com.proyecto.Proyecto.PApiKardex.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class KardexItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kardexItemid;
    private Long cantidad;
    private String tipoMov;
    private String productoSK;
    @ManyToOne
    @JoinColumn(name = "kardexId") //Para que se genere la foreign key
    private Kardex kardex;
    
}
