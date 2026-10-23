package com.spartacus.interfaces;

import java.sql.SQLException;
import com.spartacus.model.desconto;

public interface INTERFACE_desconto {
    public void cadastrar(desconto desconto) throws SQLException;
}