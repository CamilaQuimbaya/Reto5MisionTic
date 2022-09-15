/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author laura
 */
public class Cuenta {
    private int num_cuenta;
    private String tipo_cuenta;
    private int saldo;
    private int id_cliente;

    public Cuenta(int num_cuenta, String tipo_cuenta, int saldo, int id_cliente) {
        this.num_cuenta = num_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
    }
    
    

    public Cuenta(String tipo_cuenta, int saldo, int id_cliente) {
        this.tipo_cuenta = tipo_cuenta;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
    }

    public Cuenta() {
    }
    
    

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(int num_cuenta) {
        this.num_cuenta = num_cuenta;
    }
    
    

    @Override
    public String toString() {
        return "Cuenta{" + "tipo_cuenta=" + tipo_cuenta + ", saldo=" + saldo + ", id_cliente=" + id_cliente + '}';
    }    
}
