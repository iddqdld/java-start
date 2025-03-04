package com.monprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    String url = "jdbc:mysql://localhost:3306/mydbjava";
    String utilisateur = "root";
    String motDePasse = "";
    Connection connexion = null;
    
    public Connexion () {
        try {
            this.connexion = DriverManager.getConnection(this.url, this.utilisateur, this.motDePasse);
            System.out.println("Connexion établie");

        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion : " + e.getMessage());
        }
    }

    public void close() {
        if (this.connexion != null) {
            try {
                this.connexion.close();
                System.out.println("Connexion fermee");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}