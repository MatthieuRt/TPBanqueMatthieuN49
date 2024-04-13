/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquematthieun49.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import mg.itu.tpbanquematthieun49.entity.CompteBancaire;
import mg.itu.tpbanquematthieun49.service.GestionnaireCompte;

/**
 * Bean CDI qui va créér des comptes si la table est vide
 *
 * @author Matthieu R
 */
@ApplicationScoped
public class Init {

    @Inject
    GestionnaireCompte gestionnaireCompte;

    public void init(@Observes
            @Initialized(ApplicationScoped.class) ServletContext context) {
        if (gestionnaireCompte.nbComptes() == 0) {
            CompteBancaire c1 = new CompteBancaire("John Lennon", 150000);
            CompteBancaire c2 = new CompteBancaire("Paul McCartney", 950000);
            CompteBancaire c3 = new CompteBancaire("Ringo Starr", 20000);
            CompteBancaire c4 = new CompteBancaire("Georges Harrisson", 10000);
            gestionnaireCompte.creerCompte(c1);
            gestionnaireCompte.creerCompte(c2);
            gestionnaireCompte.creerCompte(c3);
            gestionnaireCompte.creerCompte(c4);
        }
    }

}
