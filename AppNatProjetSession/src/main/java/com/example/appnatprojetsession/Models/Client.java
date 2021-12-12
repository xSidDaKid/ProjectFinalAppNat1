package com.example.appnatprojetsession.Models;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Client {

    private int codeClient;
    private String nom;
    private String prenom;
    private String telephone;
    private String courriel;
    private String numeroNIP;

    public Client(int codeClient, String nom, String prenom, String telephone, String courriel, String numeroNIP) {
        this.codeClient = codeClient;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.courriel = courriel;
        this.numeroNIP = numeroNIP;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumeroNIP() {
        return numeroNIP;
    }

    public void setNumeroNIP(String numeroNIP) {
        this.numeroNIP = numeroNIP;
    }

    @Override
    public String toString() {
        return "Client{" +
                "codeClient=" + codeClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", courriel='" + courriel + '\'' +
                ", numeroNIP=" + numeroNIP +
                '}';
    }
}
