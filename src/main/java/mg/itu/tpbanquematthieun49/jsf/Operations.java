/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquematthieun49.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.List;
import mg.itu.tpbanquematthieun49.entity.CompteBancaire;
import mg.itu.tpbanquematthieun49.entity.OperationBancaire;
import mg.itu.tpbanquematthieun49.service.GestionnaireCompte;

/**
 *
 * @author Matthieu R
 */
@Named(value = "operations")
@RequestScoped
public class Operations {

    @Inject
    GestionnaireCompte gestionnaireCompte;
    private Long idCompte;
    private CompteBancaire compte;

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public List<OperationBancaire> getListeOperations() {
        return this.compte.getOperations();
    }
    
    /**
     * Creates a new instance of Operations
     */
    public Operations() {
    }
    
    public void loadCompte(){
        this.compte = this.gestionnaireCompte.findById(this.getIdCompte());
    }
    
}
