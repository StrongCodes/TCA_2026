package com.spartacus.interfaces;

import java.sql.SQLException;
import com.spartacus.model.locacao;

public interface INTERFACE_locacao {
    public void cadastrar(locacao locacao) throws SQLException;
}