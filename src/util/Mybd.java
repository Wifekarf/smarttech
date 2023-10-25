/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author MSI
 */
public class Mybd {
    final String url = "jdbc:mysql://127.0.01:3306/smartech"; 
    final String login = "root";
    final String password = "";
    Connection connexion;
    static Mybd instance;

    private Mybd() {
        try {
            connexion = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion à la base de données");
        }
    }
    
    public static  Mybd getInstance(){
        if(instance == null)
            instance = new Mybd();
        return instance;
    }
    
    public Connection getConnection(){
        return connexion; 
    }
    
}
