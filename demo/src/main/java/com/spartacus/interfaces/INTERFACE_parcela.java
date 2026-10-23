package com.spartacus.interfaces;

import java.sql.SQLException;
import com.spartacus.model.parcela;

public interface INTERFACE_parcela {
    public void cadastrar(parcela parcela) throws SQLException;
}