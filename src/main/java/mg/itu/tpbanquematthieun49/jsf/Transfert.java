/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquematthieun49.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import mg.itu.tpbanquematthieun49.service.GestionnaireCompte;

/**
 *
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

    public String transferer(){
        gestionnaireCompte.transfererArgent(idSource, idDestination, montant);
        return "listeComptes?faces-redirect=true";
    }
}
