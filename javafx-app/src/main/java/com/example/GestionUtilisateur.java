package com.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionUtilisateur {
    private final Connexion dbConnexion;

    public GestionUtilisateur() {
        this.dbConnexion = new Connexion();
    }

    public List<Utilisateur> afficherUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String query = "SELECT * FROM utilisateurs";
        
        try (PreparedStatement statement = dbConnexion.connexion.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String nom = resultSet.getString("nom");
                utilisateurs.add(new Utilisateur(id, email, nom));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des utilisateurs : " + e.getMessage());
        }
        return utilisateurs;
    }

    public void ajouterUtilisateur(String email, String nom) {
        String query = "INSERT INTO utilisateurs (email, nom) VALUES (?, ?)";
        
        try (PreparedStatement statement = dbConnexion.connexion.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, nom);
            statement.executeUpdate();
            System.out.println("Utilisateur ajouté : " + email + ", " + nom);
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }

    public void retirerUtilisateur(int id) {
        String query = "DELETE FROM utilisateurs WHERE id = ?";
        
        try (PreparedStatement statement = dbConnexion.connexion.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Utilisateur retiré : " + id);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
        }
    }

    public void mettreAJourUtilisateur(int id, String email, String nom) {
        String query = "UPDATE utilisateurs SET email = ?, nom = ? WHERE id = ?";
        
        try (PreparedStatement statement = dbConnexion.connexion.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, nom);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Utilisateur mis à jour : " + id + ", " + email + ", " + nom);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
        }
    }

    public List<Utilisateur> rechercherUtilisateurParEmail(String email) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String query = "SELECT * FROM utilisateurs WHERE email = ?";
        
        try (PreparedStatement statement = dbConnexion.connexion.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nom = resultSet.getString("nom");
                    utilisateurs.add(new Utilisateur(id, email, nom));
                } else {
                    System.out.println("Utilisateur non trouvé");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche de l'utilisateur : " + e.getMessage());
        }
        return utilisateurs;
    }

    public List<Utilisateur> rechercherUtilisateurs(String searchField, String searchValue) {
    List<Utilisateur> utilisateurs = new ArrayList<>();
    String query = "SELECT * FROM utilisateurs WHERE ";
    
    // Validate search field
    switch (searchField.toLowerCase()) {
        case "id":
            query += "id = ?";
            break;
        case "email":
            query += "email LIKE ?";
            break;
        case "nom":
            query += "nom LIKE ?";
            break;
        default:
            throw new IllegalArgumentException("Champ de recherche invalide. Utilisez 'id', 'email' ou 'nom'");
    }
    
    try (PreparedStatement statement = dbConnexion.connexion.prepareStatement(query)) {
        // Set parameter based on search field type
        if (searchField.equalsIgnoreCase("id")) {
            try {
                statement.setInt(1, Integer.parseInt(searchValue));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("L'ID doit être un nombre entier");
            }
        } else {
            // For email and nom, use LIKE with wildcards
            statement.setString(1, "%" + searchValue + "%");
        }
        
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String nom = resultSet.getString("nom");
                utilisateurs.add(new Utilisateur(id, email, nom));
            }
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la recherche : " + e.getMessage());
    }
    
    return utilisateurs;
    }

    public void closeConnection() {
        if (dbConnexion != null) {
            dbConnexion.close();
        }
    }
}