package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_motor;

public class motor implements INTERFACE_motor{
    private int id_motor_pk;
    private String Potencia_motor;
    private String Tipo_motor;
    private int NumDeCilindros_motor;    

    public motor(int id_motor_pk, String Potencia_motor, String Tipo_motor, int NumDeCilindros_motor){
        this.id_motor_pk = id_motor_pk;
        this.Potencia_motor = Potencia_motor;
        this.Tipo_motor = Tipo_motor;
        this.NumDeCilindros_motor = NumDeCilindros_motor;
    }

    public int getId_Motor(){
        return id_motor_pk;
    }

    public String getPotencia_Motor(){
        return Potencia_motor;
    }

    public String getTipoMotor_Motor(){
        return Tipo_motor;
    } 

    public int getNumCilindros_Motor(){
        return NumDeCilindros_motor;
    }
}