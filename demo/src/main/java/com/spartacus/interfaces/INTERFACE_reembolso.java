package com.spartacus.interfaces;

import java.sql.SQLException;
import com.spartacus.model.reembolso;

public interface INTERFACE_reembolso {
    public void cadastrar(reembolso reembolso) throws SQLException;
}