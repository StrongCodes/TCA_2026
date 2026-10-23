package com.spartacus.interfaces;

import java.sql.SQLException;
import com.spartacus.model.carroDisponivel;

public interface INTERFACE_carroDisponivel {
    public void cadastrar(carroDisponivel carro) throws SQLException;
}