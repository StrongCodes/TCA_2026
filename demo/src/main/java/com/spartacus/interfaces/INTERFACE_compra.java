package com.spartacus.interfaces;

import java.sql.SQLException;
import com.spartacus.model.compra;

public interface INTERFACE_compra {
    public void cadastrar(compra compra) throws SQLException;
}