/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base_datos;

import clases.Conexion;
import clases.Cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author laura
 */
public class CuentaDao {
    public boolean registrar_cuenta(Cuenta cuenta){
        Connection conexionDB = null;
        boolean datos = true;
        conexionDB = Conexion.getConexion();
        PreparedStatement prdstmt = null;
        try{
            String strSentencia = "insert into cuenta.cuenta\n" +
                                    "(tipo, saldo, id_cliente)\n" +
                                    "values\n" +
                                    "(?,?,?);";
            prdstmt = conexionDB.prepareStatement(strSentencia);
            prdstmt.setString(1, cuenta.getTipo_cuenta());
            prdstmt.setInt(2, cuenta.getSaldo());
            prdstmt.setInt(3, cuenta.getId_cliente());
            
            datos = prdstmt.execute();
            System.out.println("cuenta creada" + datos);
        }catch(Exception e){
            System.out.println("Error al crear la cuenta " + e);
        }finally{
            Conexion.cloConexion();
            try{
                prdstmt.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la base de datos " + e);
            }
        }
        return datos;
    }
    
    public ArrayList<Cuenta> actualizar_tabla(){
        Connection conexionDB = null;
        conexionDB = Conexion.getConexion();
        PreparedStatement prdstmt = null;
        Cuenta cuenta = new Cuenta();
        
        ArrayList<Cuenta> arr_cuentas = new ArrayList<Cuenta>();
        try{
            String strSentencia = "select num_cuenta, tipo, saldo, id_cliente\n" +
                                    "from cuenta.cuenta;";
            prdstmt = conexionDB.prepareStatement(strSentencia);
            ResultSet resultado = prdstmt.executeQuery();
            
            while(resultado.next()){
                int numTemp = resultado.getInt(1);
                String tipoTemp = resultado.getString(2);
                int saldoTemp = resultado.getInt(3);
                int idTemp = resultado.getInt(4);
                arr_cuentas.add(new Cuenta(numTemp, tipoTemp, saldoTemp, idTemp));
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
        return arr_cuentas;
    }
    
}
