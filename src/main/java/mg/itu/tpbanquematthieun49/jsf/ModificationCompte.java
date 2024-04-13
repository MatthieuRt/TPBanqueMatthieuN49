/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquematthieun49.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import mg.itu.tpbanquematthieun49.entity.CompteBancaire;
import mg.itu.tpbanquematthieun49.jsf.util.Util;
import mg.itu.tpbanquematthieun49.service.GestionnaireCompte;

/**
 * Backing Bean pour la modification de compte
 * @author Matthieu R
 */
@Named(value = "modificationCompte")
@ViewScoped
public class ModificationCompte implements Serializable{

    @Inject
    GestionnaireCompte gestionnaireCompte;
    
    private long id;
    private String ancienNom;
    private CompteBancaire compteBancaire;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public String getAncienNom() {
        return ancienNom;
    }

    public void setAncienNom(String ancienNom) {
        this.ancienNom = ancienNom;
    }
    
    /**
     * Creates a new instance of ModificationCompte
     */
    public ModificationCompte() {
    }
    
    public void loadCompte() {
        this.compteBancaire = gestionnaireCompte.findById(this.id);
        this.ancienNom = this.compteBancaire.getNom();
    }
    
    public String modifierCompte(){
        gestionnaireCompte.update(this.compteBancaire);
        Util.addFlashInfoMessage("Nom : "+this.ancienNom+" changé en "+this.compteBancaire.getNom());
        return "listeComptes?faces-redirect=true";
    }
    
}
