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
import model.Etat;
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
@Named("EtatService")
public class EtatService implements Serializable{
    
    private static final long serialVersionUID = 1L;
	Session session=null;

    public EtatService () {
    }
        
        
        
    public ArrayList<Etat> getAllEtat(){
        ArrayList<Etat> allEtat = new ArrayList<>();
        try {
		this.session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		Query req = session.createQuery("from Etat e order by e.nom");
            allEtat = (ArrayList<Etat>) req.list();
            tx.commit();
            //session.clear();
		} catch (HibernateException e) {
		  System.out.println("Erreur dans getAllEtat\n"+e);
		}
        return allEtat;
    }
    
    
    
    
 
    
    
    
    public int deleteEtat(Etat EtatToDelete){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String strReq="delete from Etat e where e.id=?";
            Query req = session.createQuery(strReq).setInteger(0, EtatToDelete.getId());
            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Etat supprimée avec succès");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans deleteEtat\n"+e);
		}
		return result;
	}
	
	public int updateEtat(Etat EtatToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.update(EtatToUpdate);
            tx.commit();
            if(result>0){
            	System.out.println("Etat  ajouté avec succes");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans updateEtat\n"+e);
		}
		return result;
	}
	
    /**
     *
     * @param EtatToUpdate
     * @return
     */
    public int addEtat(Etat EtatToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			//MatToUpdate.setDepartement(getDepartementByID(idEtat));
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.save(EtatToUpdate);
//			String strReq="insert into User(nom,prenom,login,password,profile,iddepartement)";
//            Query req = session.createQuery(strReq).setString(0, userToUpdate.getNom()).setString(1, userToUpdate.getPrenom()).setString(2, userToUpdate.getLogin()).setString(3, userToUpdate.getPassword()).setString(4, userToUpdate.getProfile()).setInteger(5, idDep);
//            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Etat  Ajouté avec succés");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println(e+"Erreur dans addEtat\n");
            session.close();
		}
		return result;
	}
}

