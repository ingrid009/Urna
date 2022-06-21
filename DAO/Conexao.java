/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class Conexao {
    public static Connection abrirConexao(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/urna?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(url, "root", "");
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco",
                    "Urna", JOptionPane.ERROR_MESSAGE);
            e.getMessage();
        }
        return con;
    }
    
    public static void fecharConexao(Connection con){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
}
