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
import model.BoiteEtat;
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
@Named("BoiteEtatService")
public class BoiteEtatService implements Serializable{
    
    private static final long serialVersionUID = 1L;
	Session session=null;

    public BoiteEtatService () {
    }
        
        
        
    public ArrayList<BoiteEtat> getAllBoiteEtat(){
        ArrayList<BoiteEtat> allBoiteEtat = new ArrayList<>();
        try {
		this.session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		Query req = session.createQuery("from BoiteEtat be order by be.nom");
            allBoiteEtat = (ArrayList<BoiteEtat>) req.list();
            tx.commit();
            //session.clear();
		} catch (HibernateException e) {
		  System.out.println("Erreur dans getAllBoiteEtat\n"+e);
		}
        return allBoiteEtat;
    }
    
    
    
    
 
    
    
    
    public int deleteBoiteEtat(BoiteEtat BoiteEtatToDelete){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String strReq="delete from BoiteEtat be where be.id=?";
            Query req = session.createQuery(strReq).setInteger(0, BoiteEtatToDelete.getId());
            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("BoiteEtat supprimée avec succès");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans deleteBoiteEtat\n"+e);
		}
		return result;
	}
	
	public int updateBl(BoiteEtat BoiteEtatToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.update(BoiteEtatToUpdate);
            tx.commit();
            if(result>0){
            	System.out.println("boite etait  ajouté avec succes");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans updateMat\n"+e);
		}
		return result;
	}
	
    /**
     *
     * @param BoiteEtatToUpdate
     * @return
     */
    public int addBenific(BoiteEtat BoiteEtatToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			//MatToUpdate.setDepartement(getDepartementByID(idDep));
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.save(BoiteEtatToUpdate);
//			String strReq="insert into User(nom,prenom,login,password,profile,iddepartement)";
//            Query req = session.createQuery(strReq).setString(0, userToUpdate.getNom()).setString(1, userToUpdate.getPrenom()).setString(2, userToUpdate.getLogin()).setString(3, userToUpdate.getPassword()).setString(4, userToUpdate.getProfile()).setInteger(5, idDep);
//            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("BoiteEtat  Ajouté avec succés");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println(e+"Erreur dans addBoiteEtat\n");
            session.close();
		}
		return result;
	}
}
