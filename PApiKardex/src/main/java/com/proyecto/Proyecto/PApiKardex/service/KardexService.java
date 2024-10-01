
package com.proyecto.Proyecto.PApiKardex.service;

import com.proyecto.Proyecto.PApiKardex.dto.Transaction;
import com.proyecto.Proyecto.PApiKardex.dto.TransactionResponse;

public interface KardexService {
        public TransactionResponse placeKardex(Transaction transaction);

}
