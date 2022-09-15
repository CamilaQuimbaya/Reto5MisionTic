/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author laura
 */
public class Cliente {
    private long id_cliente;
    private String nombre;
    private String email;
    private String password;

    public Cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }    

    public Cliente(long id_cliente, String nombre, String email) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.email = email;
    }
    
    
    
    public Cliente(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public Cliente() {
    }

    public Cliente(long id_cliente, String nombre) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
    }    

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.valueOf(id_cliente);
    }
}
