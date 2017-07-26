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
import model.Secteur;
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
@Named("SecteurService")
public class SecteurService implements Serializable{
    
    private static final long serialVersionUID = 1L;
	Session session=null;

    public SecteurService () {
    }
        
        
        
    public ArrayList<Secteur> getAllSecteur(){
        ArrayList<Secteur> allSecteur = new ArrayList<>();
        try {
		this.session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		Query req = session.createQuery("from Secteur s order by s.nom");
            allSecteur = (ArrayList<Secteur>) req.list();
            tx.commit();
            //session.clear();
		} catch (HibernateException e) {
		  System.out.println("Erreur dans getAllSecteur\n"+e);
		}
        return allSecteur;
    }
    
    
    
    
 
    
    
    
    public int deleteSecteur(Secteur SecteurToDelete){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String strReq="delete from Secteur s where s.id=?";
            Query req = session.createQuery(strReq).setInteger(0, SecteurToDelete.getId());
            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Secteur supprimée avec succès");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans deleteSecteur\n"+e);
		}
		return result;
	}
	
	public int updateSecteur(Secteur SecteurToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.update(SecteurToUpdate);
            tx.commit();
            if(result>0){
            	System.out.println("Secteur  ajouté avec succes");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans updateSecteur\n"+e);
		}
		return result;
	}
	
    /**
     *
     * @param SecteurToUpdate
     * @return
     */
    public int addSecteur(Secteur SecteurToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			//MatToUpdate.setDepartement(getDepartementByID(idDep));
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.save(SecteurToUpdate);
//			String strReq="insert into User(nom,prenom,login,password,profile,iddepartement)";
//            Query req = session.createQuery(strReq).setString(0, userToUpdate.getNom()).setString(1, userToUpdate.getPrenom()).setString(2, userToUpdate.getLogin()).setString(3, userToUpdate.getPassword()).setString(4, userToUpdate.getProfile()).setInteger(5, idDep);
//            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Secteur  Ajouté avec succés");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println(e+"Erreur dans addSecteur\n");
            session.close();
		}
		return result;
	}
}

