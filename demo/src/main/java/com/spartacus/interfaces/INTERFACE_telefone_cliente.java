
package com.spartacus.interfaces;

import com.spartacus.model.telefone_cliente;
import java.sql.SQLException;

public interface INTERFACE_telefone_cliente {
    void cadastrar(telefone_cliente telefone) throws SQLException;
}