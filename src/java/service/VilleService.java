/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Ville;
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
@Named("villeService")
public class VilleService implements Serializable  {
    
    private static final long serialVersionUID = 1L;
	Session session=null;
        
        public VilleService() {
    }
    
    
    public ArrayList<Ville> getAllVille(){
        ArrayList<Ville> allVille = new ArrayList<>();
        try {
		this.session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		Query req = session.createQuery("from Ville v order by v.type");
            allVille = (ArrayList<Ville>) req.list();
            tx.commit();
            //session.clear();
		} catch (HibernateException e) {
		  System.out.println("Erreur dans getAllVille\n"+e);
		}
        return allVille;
    }
    
   public int deleteBl(Ville VilleToDelete){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String strReq="delete from Ville v where v.id=?";
            Query req = session.createQuery(strReq).setInteger(0, VilleToDelete.getId());
            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Ville  supprimée avec succès");
            }
            //session.clear();
		} catch (Exception e) {
			System.out.println("Erreur dans deleteVille\n"+e);
                        e.printStackTrace();
		}
		return result;
	}
    
   public int updateBl(Ville VilleToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.update(VilleToUpdate);
            tx.commit();
            if(result>0){
            	System.out.println("Ville Mis Ã  jour avec succÃ¨s avec succÃ¨s");
            }
            //session.clear();
		} catch (Exception e) {
			System.out.println("Erreur dans updateVille\n"+e);
            e.printStackTrace();
		}
		return result;
	}
    
   public int addVille(Ville VilleToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			//MatToUpdate.setDepartement(getDepartementByID(idDep));
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.save(VilleToUpdate);

            tx.commit();
            if(result>0){
            	System.out.println("Ville Ajoute avec succés");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans addVille\n"+e);
            session.close();
		}
		return result;
	}
    
}
