/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquematthieun49.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Matthieu R
 */
@Entity
public class OperationBancaire implements Serializable {
    private static final long serialVersionUID = 1L; 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime dateOperation;
    private int montant;
                    
    public OperationBancaire() { }
                    
    public OperationBancaire(String description, int montant) {
        this.description = description;
        this.montant = montant;
        dateOperation = LocalDateTime.now();
    }   

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateOperation() {
        return dateOperation;
    }

    public int getMontant() {
        return montant;
    }
    
    
}
