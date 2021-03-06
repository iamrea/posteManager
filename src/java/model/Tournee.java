package model;
// Generated May 25, 2017 6:09:16 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tournee generated by hbm2java
 */
public class Tournee  implements java.io.Serializable {


     private Integer id;
     private Secteur secteur;
     private int numero;
     private int cp;
     private Date dateCreation;
     private int reference;
     private int indemnite;
     private int frequenceDistribution;
     private Date dateMaj;
     private Set boitelettreses = new HashSet(0);
     private Set cyclos = new HashSet(0);

    public Tournee() {
    }

	
    public Tournee(Secteur secteur, int numero, int cp, Date dateCreation, int reference, int indemnite, int frequenceDistribution, Date dateMaj) {
        this.secteur = secteur;
        this.numero = numero;
        this.cp = cp;
        this.dateCreation = dateCreation;
        this.reference = reference;
        this.indemnite = indemnite;
        this.frequenceDistribution = frequenceDistribution;
        this.dateMaj = dateMaj;
    }
    public Tournee(Secteur secteur, int numero, int cp, Date dateCreation, int reference, int indemnite, int frequenceDistribution, Date dateMaj, Set boitelettreses, Set cyclos) {
       this.secteur = secteur;
       this.numero = numero;
       this.cp = cp;
       this.dateCreation = dateCreation;
       this.reference = reference;
       this.indemnite = indemnite;
       this.frequenceDistribution = frequenceDistribution;
       this.dateMaj = dateMaj;
       this.boitelettreses = boitelettreses;
       this.cyclos = cyclos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Secteur getSecteur() {
        return this.secteur;
    }
    
    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getCp() {
        return this.cp;
    }
    
    public void setCp(int cp) {
        this.cp = cp;
    }
    public Date getDateCreation() {
        return this.dateCreation;
    }
    
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public int getReference() {
        return this.reference;
    }
    
    public void setReference(int reference) {
        this.reference = reference;
    }
    public int getIndemnite() {
        return this.indemnite;
    }
    
    public void setIndemnite(int indemnite) {
        this.indemnite = indemnite;
    }
    public int getFrequenceDistribution() {
        return this.frequenceDistribution;
    }
    
    public void setFrequenceDistribution(int frequenceDistribution) {
        this.frequenceDistribution = frequenceDistribution;
    }
    public Date getDateMaj() {
        return this.dateMaj;
    }
    
    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
    }
    public Set getBoitelettreses() {
        return this.boitelettreses;
    }
    
    public void setBoitelettreses(Set boitelettreses) {
        this.boitelettreses = boitelettreses;
    }
    public Set getCyclos() {
        return this.cyclos;
    }
    
    public void setCyclos(Set cyclos) {
        this.cyclos = cyclos;
    }




}


