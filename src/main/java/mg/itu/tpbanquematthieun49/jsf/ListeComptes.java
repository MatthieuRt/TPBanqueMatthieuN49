/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquematthieun49.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.itu.tpbanquematthieun49.entity.CompteBancaire;
import mg.itu.tpbanquematthieun49.jsf.util.Util;
import mg.itu.tpbanquematthieun49.service.GestionnaireCompte;

/**
 *
 * @author Matthieu R
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    @Inject
    GestionnaireCompte gestionnaireCompte;

    private List<CompteBancaire> compteBancaires;

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }

    public List<CompteBancaire> getAllComptes() {
        if (compteBancaires == null) {
            compteBancaires = gestionnaireCompte.getAllComptes();
        }
        return compteBancaires;
    }

    public String supprimerCompte(CompteBancaire compteBancaire) {
        gestionnaireCompte.supprimerCompte(compteBancaire);
        Util.addFlashInfoMessage("Compte de " + compteBancaire.getNom() + " supprimé");
        return "listeComptes?faces-redirect=true";
    }

}
