/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import model.Facteur;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import orm.HibernateUtil;

/**
 *
 * @author Rabab
 */
@RequestScoped
@Named("FacteurService")
public class FacteurService implements Serializable{
    
    private static final long serialVersionUID = 1L;
	Session session=null;

    public FacteurService () {
    }
        
        
        
    public ArrayList<Facteur> getAllFacteur(){
        ArrayList<Facteur> allFacteur = new ArrayList<>();
        try {
		this.session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		Query req = session.createQuery("from Facteur f order by f.nom");
            allFacteur = (ArrayList<Facteur>) req.list();
            tx.commit();
            //session.clear();
		} catch (HibernateException e) {
		  System.out.println("Erreur dans getAllFacteur\n"+e);
		}
        return allFacteur;
    }
    
    
    
    
 
    
    
    
    public int deleteFacteur(Facteur FacteurToDelete){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String strReq="delete from Facteur f where f.id=?";
            Query req = session.createQuery(strReq).setInteger(0, FacteurToDelete.getId());
            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Facteur supprimée avec succès");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans deleteFacteur\n"+e);
		}
		return result;
	}
	
	public int updateFacteur(Facteur FacteurToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.update(FacteurToUpdate);
            tx.commit();
            if(result>0){
            	System.out.println("Facteur etait  ajouté avec succes");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans updateFacteur\n"+e);
		}
		return result;
	}
	
    /**
     *
     * @param FacteurToUpdate
     * @return
     */
    public int addFacteur(Facteur FacteurToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			//MatToUpdate.setDepartement(getDepartementByID(idDep));
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.save(FacteurToUpdate);
//			String strReq="insert into User(nom,prenom,login,password,profile,iddepartement)";
//            Query req = session.createQuery(strReq).setString(0, userToUpdate.getNom()).setString(1, userToUpdate.getPrenom()).setString(2, userToUpdate.getLogin()).setString(3, userToUpdate.getPassword()).setString(4, userToUpdate.getProfile()).setInteger(5, idDep);
//            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Facteur  Ajouté avec succés");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println(e+"Erreur dans addFacteur\n");
            session.close();
		}
		return result;
	}
}

