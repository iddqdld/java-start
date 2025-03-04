package com.monprojet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionUtilisateurs {
    ArrayList utilisateurs = new ArrayList();
    Connexion link = new Connexion();

    public GestionUtilisateurs(Connexion plink) {
        this.link = plink;
    }

    public void listUtilisateur() {
        if (this.link.connexion == null) {
            System.err.println("Error: Database connection is not established");
            return;
        }
        
        try {
            Statement stmt = this.link.connexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, nom, email FROM utilisateurs");
            System.out.println("Liste des utilisateurs :");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                System.out.println("ID : " + id + " - Nom : " + nom + " - Email : " + email);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }
    }
    public void addUser(String nom, String email) {
        try {
            String query = "INSERT INTO utilisateurs (nom, email) VALUES (?, ?)";
            PreparedStatement preparedStmt = this.link.connexion.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, email);

            int rowsAffected = preparedStmt.executeUpdate();
            System.out.println("Nombre de lignes affectées : " + rowsAffected);

        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }
}
