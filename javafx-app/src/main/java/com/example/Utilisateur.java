package com.example;

public class Utilisateur {
    private final int id;
    private String email;
    private String nom;

    public Utilisateur(int id, String email, String nom) {
        this.id = id;
        this.email = email;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}