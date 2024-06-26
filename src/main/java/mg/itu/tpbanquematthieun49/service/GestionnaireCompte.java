/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquematthieun49.service;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.itu.tpbanquematthieun49.entity.CompteBancaire;

/**
 * Façade pour gérer les Comptes Bancaires.
 *
 * @author Matthieu R
 */
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "root", // nom et
        password = "root", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true",
            "driverClass=com.mysql.cj.jdbc.Driver"
        }
)
@ApplicationScoped
public class GestionnaireCompte {

    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;

    @Transactional
    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }

    public List<CompteBancaire> getAllComptes() {
        TypedQuery<CompteBancaire> query = em.createNamedQuery("CompteBancaire.findAll", CompteBancaire.class);
        return query.getResultList();
    }

    public CompteBancaire findById(Long idCompteBancaire) {
        return em.find(CompteBancaire.class, idCompteBancaire);
    }

    @Transactional
    public void transfererArgent(CompteBancaire source, CompteBancaire destination, int montant) {
//        CompteBancaire source = this.findById(idSource);
//        CompteBancaire destination = this.findById(idDestination);

        source.setSolde(source.getSolde() - montant);
        destination.setSolde(destination.getSolde() + montant);

        update(source);
        update(destination);
    }

    @Transactional
    public void update(CompteBancaire compteBancaire) {
        em.merge(compteBancaire);
    }

    @Transactional
    public Long nbComptes() {
        TypedQuery<Long> query = em.createNamedQuery("CompteBancaire.count", Long.class);
        // Exécutez la requête et récupérez le résultat
        Long compteCount = query.getSingleResult();
        // Retournez le nombre de comptes
        return compteCount;
    }

    /**
     * Dépôt d'argent sur un compte bancaire.
     *
     * @param compteBancaire
     * @param montant
     */
    @Transactional
    public void deposer(CompteBancaire compteBancaire, int montant) {
        compteBancaire.deposer(montant);
        update(compteBancaire);
    }

    /**
     * Retrait d'argent sur un compte bancaire.
     *
     * @param compteBancaire
     * @param montant
     */
    @Transactional
    public void retirer(CompteBancaire compteBancaire, int montant) {
        compteBancaire.retirer(montant);
        update(compteBancaire);
    }

    @Transactional
    public void supprimerCompte(CompteBancaire compte) {
        em.remove(em.merge(compte));
    }
}
