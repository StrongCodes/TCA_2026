package com.spartacus.interfaces;
import java.sql.SQLException;
import com.spartacus.model.carro;

public interface INTERFACE_carro {
    public void cadastrar(carro carro) throws SQLException;
}