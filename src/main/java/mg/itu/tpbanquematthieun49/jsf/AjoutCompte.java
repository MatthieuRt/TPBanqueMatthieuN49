/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquematthieun49.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.PositiveOrZero;
import mg.itu.tpbanquematthieun49.entity.CompteBancaire;
import mg.itu.tpbanquematthieun49.jsf.util.Util;
import mg.itu.tpbanquematthieun49.service.GestionnaireCompte;

/**
 *
 * @author Matthieu R
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {

    @Inject
    GestionnaireCompte gestionnaireCompte;

    private String nom;

    @PositiveOrZero
    private int solde;

    public GestionnaireCompte getGestionnaireCompte() {
        return gestionnaireCompte;
    }

    public void setGestionnaireCompte(GestionnaireCompte gestionnaireCompte) {
        this.gestionnaireCompte = gestionnaireCompte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }

    public String creerCompte() {
        CompteBancaire c = new CompteBancaire(nom, solde);
        gestionnaireCompte.creerCompte(c);
        Util.addFlashInfoMessage("Compte créé avec succès, Nom : " + nom + ", Solde : " + solde);
        return "listeComptes?faces-redirect=true";
    }

}
