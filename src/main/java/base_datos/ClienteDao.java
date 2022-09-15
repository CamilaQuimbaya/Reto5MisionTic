/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base_datos;

import clases.Cliente;
import clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author laura
 */
public class ClienteDao {
    public boolean registrar_cliente(Cliente cliente){
        Connection conexionDB = null;
        boolean datos_guardados = true;
        conexionDB = Conexion.getConexion();
        
        PreparedStatement prdstmt = null;
        
        try{
            String strSentencia = "insert into cuenta.cliente\n" +
                                    "(nombre, email, contraseña)\n" +
                                    "values\n" +
                                    "(?,?,?);";
            prdstmt = conexionDB.prepareStatement(strSentencia);
            prdstmt.setString(1, cliente.getNombre());
            prdstmt.setString(2, cliente.getEmail());
            prdstmt.setString(3, cliente.getPassword());
            datos_guardados = prdstmt.execute();
            System.out.println("Cliente creado!" + datos_guardados);
            
        }catch(Exception e){
            System.out.println("Error al guardar el cliente: " + e);
        }finally{
            Conexion.cloConexion();
            try{
                prdstmt.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return datos_guardados;
    }
    
    public ArrayList<Cliente> obtener_clientes(){
        Connection conexionDB = null;
        conexionDB = Conexion.getConexion();
        PreparedStatement prdstmt = null;
        Cliente cliente = new Cliente();
        
        ArrayList<Cliente> arr_clientes = new ArrayList<Cliente>();
        try{
            String strSentencia = "select id_cliente\n" +
                                "from cuenta.cliente;";
            prdstmt = conexionDB.prepareStatement(strSentencia);
            ResultSet resultado = prdstmt.executeQuery();
            
            while(resultado.next()){
                int idTemp = resultado.getInt(1);
                arr_clientes.add(new Cliente(idTemp));
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }finally{
            Conexion.cloConexion();
            try{
                prdstmt.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la base de datos " + e);
            }
        }
        return arr_clientes;
    }

    public ArrayList<Cliente> actualizar_tabla(){
        Connection conexionDB = null;
        conexionDB = Conexion.getConexion();
        PreparedStatement prdstmt = null;
        Cliente cliente = new Cliente();
        
        ArrayList<Cliente> arr_clientes = new ArrayList<Cliente>();
        try{
            String strSentencia = "select id_cliente, nombre, email\n" +
                                "from cuenta.cliente;";
            prdstmt = conexionDB.prepareStatement(strSentencia);
            ResultSet resultado = prdstmt.executeQuery();
            
            while(resultado.next()){
                int idTemp = resultado.getInt(1);
                String nombreTemp = resultado.getString(2);
                String emailTemp = resultado.getString(3);
                arr_clientes.add(new Cliente(idTemp, nombreTemp, emailTemp));
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }finally{
            Conexion.cloConexion();
            try{
                prdstmt.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la base de datos " + e);
            }
        }
        return arr_clientes;
    }
}
