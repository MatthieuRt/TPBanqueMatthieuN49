/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mg.itu.tpbanquematthieun49.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la classe CompteBancaire
 * @author Matthieu R
 */
public class CompteBancaireTest {

    public CompteBancaireTest() {
    }

    @Test
    public void testConstructor() {
        int montant = 100;
        CompteBancaire instance = new CompteBancaire("totoa", montant);
        assertEquals(instance.getNom(), "toto", "Nom titulaire compte mal enregistré dans l'instance");
        assertEquals(instance.getSolde(), montant, "Montant compte mal enregistré dans l'instance");
    }

    /**
     * Test of deposer method, of class CompteBancaire.
     */
    @Test
    public void testDeposer() {
        System.out.println("deposer");
        int montant = 100;
        CompteBancaire instance = new CompteBancaire();
        instance.deposer(montant);
        assertEquals(instance.getSolde(), montant, "Mauvais calcul du solde après un dépôt");
    }
}
