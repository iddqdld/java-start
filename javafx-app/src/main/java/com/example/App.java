package com.example;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private GestionUtilisateur gestionUtilisateur;
    private ListView<String> userListView;

    @Override
    public void start(Stage stage) {
        gestionUtilisateur = new GestionUtilisateur();
        
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));

        // Search section
        GridPane searchPane = new GridPane();
        searchPane.setHgap(10);
        searchPane.setVgap(5);
        
        ComboBox<String> searchField = new ComboBox<>();
        searchField.getItems().addAll("id", "email", "nom");
        searchField.setValue("email");
        
        TextField searchInput = new TextField();
        Button searchButton = new Button("Rechercher");
        
        searchPane.add(new Label("Rechercher par:"), 0, 0);
        searchPane.add(searchField, 1, 0);
        searchPane.add(searchInput, 2, 0);
        searchPane.add(searchButton, 3, 0);

        // Add user section
        GridPane addUserPane = new GridPane();
        addUserPane.setHgap(10);
        addUserPane.setVgap(5);
        
        TextField emailInput = new TextField();
        TextField nomInput = new TextField();
        Button addButton = new Button("Ajouter Utilisateur");
        
        addUserPane.add(new Label("Email:"), 0, 0);
        addUserPane.add(emailInput, 1, 0);
        addUserPane.add(new Label("Nom:"), 2, 0);
        addUserPane.add(nomInput, 3, 0);
        addUserPane.add(addButton, 4, 0);

        // User list
        userListView = new ListView<>();
        userListView.setPrefHeight(400);

        // Action buttons
        Button refreshButton = new Button("Actualiser");
        Button deleteButton = new Button("Supprimer");
        HBox buttonBox = new HBox(10, refreshButton, deleteButton);

        mainLayout.getChildren().addAll(searchPane, addUserPane, userListView, buttonBox);

        // Event handlers
        searchButton.setOnAction(e -> {
            String field = searchField.getValue();
            String value = searchInput.getText();
            updateListView(gestionUtilisateur.rechercherUtilisateurs(field, value));
        });

        addButton.setOnAction(e -> {
            String email = emailInput.getText();
            String nom = nomInput.getText();
            if (!email.isEmpty() && !nom.isEmpty()) {
                gestionUtilisateur.ajouterUtilisateur(email, nom);
                refreshList();
                emailInput.clear();
                nomInput.clear();
            }
        });

        refreshButton.setOnAction(e -> refreshList());

        deleteButton.setOnAction(e -> {
            String selected = userListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                int id = Integer.parseInt(selected.split(":")[0].trim());
                gestionUtilisateur.retirerUtilisateur(id);
                refreshList();
            }
        });

        // Initial list load
        refreshList();

        Scene scene = new Scene(mainLayout, 800, 600);
        stage.setTitle("Gestion des Utilisateurs");
        stage.setScene(scene);
        stage.show();
    }

    private void updateListView(List<Utilisateur> users) {
    try {
        userListView.getItems().clear();
        
        if (users == null || users.isEmpty()) {
            userListView.getItems().add("Aucun utilisateur trouvé");
            return;
        }

        for (Utilisateur user : users) {
            if (user != null) {
                String userString = String.format("%d: %s (%s)", 
                    user.getId(), 
                    user.getNom() != null ? user.getNom() : "Sans nom", 
                    user.getEmail() != null ? user.getEmail() : "Sans email"
                );
                userListView.getItems().add(userString);
            }
        }
    } catch (Exception e) {
        System.err.println("Erreur lors de la mise à jour de la liste: " + e.getMessage());
        userListView.getItems().add("Erreur lors du chargement des utilisateurs");
    }
    }

    private void refreshList() {
        updateListView(gestionUtilisateur.afficherUtilisateurs());
    }

    @Override
    public void stop() {
        if (gestionUtilisateur != null) {
            gestionUtilisateur.closeConnection();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}