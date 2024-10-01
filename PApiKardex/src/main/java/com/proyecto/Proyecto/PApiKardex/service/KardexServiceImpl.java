
package com.proyecto.Proyecto.PApiKardex.service;

import com.proyecto.Proyecto.PApiKardex.dao.KardexRepository;
import com.proyecto.Proyecto.PApiKardex.dto.Transaction;
import com.proyecto.Proyecto.PApiKardex.dto.TransactionResponse;
import com.proyecto.Proyecto.PApiKardex.entity.Almacen;
import com.proyecto.Proyecto.PApiKardex.entity.Kardex;
import com.proyecto.Proyecto.PApiKardex.entity.KardexItem;
import com.proyecto.Proyecto.PApiKardex.entity.Producto;
import com.proyecto.Proyecto.PApiKardex.entity.Usuario;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KardexServiceImpl implements KardexService{

    @Autowired
    private KardexRepository kardexRepository;
    
    @Autowired
    private RestClientUsuario restClientUsuario;
    
    @Autowired
    private RestClientProducto restClientProducto;
    
    @Autowired
    private RestClientAlmacen restClientAlmacen;
    
    @Override
    @Transactional
    public TransactionResponse placeKardex(Transaction transaction) {
        Kardex kardex = transaction.getKardex();
        transaction.getKardexItems().forEach(i->{kardex.addKardexItem(i);});
        Usuario usuario = restClientUsuario.findByCodigoUsu(kardex.getCodigoUsu());
        Almacen almacen = restClientAlmacen.findByCodigoAlm(kardex.getCodigoAlm());
        
        List<Producto> productos = new ArrayList<>();
        transaction.getKardexItems().forEach(i->{productos.add(restClientProducto.findByProductoSK(i.getProductoSK()));});
        
        kardexRepository.save(kardex);
        
        //Colocar metodos para sacar usuario, almacen kardexItems
        return new TransactionResponse(kardex, usuario, almacen, productos);
    }
    
    
}
