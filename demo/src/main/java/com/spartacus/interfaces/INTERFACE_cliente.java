package com.spartacus.interfaces;

import java.sql.SQLException;
import com.spartacus.model.cliente;

public interface INTERFACE_cliente {
    public void cadastrar(cliente cliente) throws SQLException;
}