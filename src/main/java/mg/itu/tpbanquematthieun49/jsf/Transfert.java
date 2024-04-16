/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquematthieun49.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import mg.itu.tpbanquematthieun49.entity.CompteBancaire;
import mg.itu.tpbanquematthieun49.jsf.util.Util;
import mg.itu.tpbanquematthieun49.service.GestionnaireCompte;

/**
 * Backing pour gérer les transferts
 * @author Matthieu R
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {

    @Inject
    GestionnaireCompte gestionnaireCompte;

    private Long idSource;
    private Long idDestination;
    private int montant;

    /**
     * Creates a new instance of Transfert
     */
    public Transfert() {
    }

    public GestionnaireCompte getGestionnaireCompte() {
        return gestionnaireCompte;
    }

    public void setGestionnaireCompte(GestionnaireCompte gestionnaireCompte) {
        this.gestionnaireCompte = gestionnaireCompte;
    }

    public Long getIdSource() {
        return idSource;
    }

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String transferer() {
        boolean erreur = false;
        CompteBancaire source = gestionnaireCompte.findById(idSource);
        CompteBancaire destination = gestionnaireCompte.findById(idDestination);
        if (source == null || destination == null) {
            // Message d'erreur associé au composant source ; form:source est l'id client
            // si l'id du formulaire est "form" et l'id du champ de saisie de l'id de la source est "source"
            // dans la page JSF qui lance le transfert.
            if(source==null){
                Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:source");
            }
            if(destination==null){
                Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:destination");
            }
             erreur = true;
        } else {
            if (source.getSolde() < montant) { 
                erreur = true;
                Util.messageErreur("Solde insuffisant pour le transfert !");
            }
            if(montant<0){
                erreur = true;
                Util.messageErreur("Le montant ne doit pas être inférieur à 0");
            }
        }
        if (erreur) { // en cas d'erreur, rester sur la même page
            return null;
        }
        gestionnaireCompte.transfererArgent(idSource, idDestination, montant);        // Message de succès ; addFlash à cause de la redirection.
        // ...Complétez pour faire apparaitre le montant et les noms des 2 propriétaires des comptes.
        Util.addFlashInfoMessage("Transfert correctement effectué, source : "+idSource+",destination : "+idDestination+",montant : "+montant);
        return "listeComptes?faces-redirect=true";
    }
}
