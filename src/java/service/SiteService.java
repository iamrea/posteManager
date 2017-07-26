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
import model.Site;
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
@Named("SiteService")
public class SiteService implements Serializable{
    
    private static final long serialVersionUID = 1L;
	Session session=null;

    public SiteService () {
    }
        
        
        
    public ArrayList<Site> getAllSite(){
        ArrayList<Site> allSite = new ArrayList<>();
        try {
		this.session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		Query req = session.createQuery("from Site s order by s.nom");
            allSite = (ArrayList<Site>) req.list();
            tx.commit();
            //session.clear();
		} catch (HibernateException e) {
		  System.out.println("Erreur dans getAllSite\n"+e);
		}
        return allSite;
    }
    
    
    
    
 
    
    
    
    public int deleteSite(Site SiteToDelete){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String strReq="delete from Site s where s.id=?";
            Query req = session.createQuery(strReq).setInteger(0, SiteToDelete.getId());
            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Site supprimée avec succès");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans deleteSite\n"+e);
		}
		return result;
	}
	
	public int updateSite(Site SiteToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.update(SiteToUpdate);
            tx.commit();
            if(result>0){
            	System.out.println("Site  ajouté avec succes");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans updateSite\n"+e);
		}
		return result;
	}
	
    /**
     *
     * @param SiteToUpdate
     * @return
     */
    public int addSite(Site SiteToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			//MatToUpdate.setDepartement(getDepartementByID(idDep));
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.save(SiteToUpdate);
//			String strReq="insert into User(nom,prenom,login,password,profile,iddepartement)";
//            Query req = session.createQuery(strReq).setString(0, userToUpdate.getNom()).setString(1, userToUpdate.getPrenom()).setString(2, userToUpdate.getLogin()).setString(3, userToUpdate.getPassword()).setString(4, userToUpdate.getProfile()).setInteger(5, idDep);
//            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Site  Ajouté avec succés");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println(e+"Erreur dans SiteSecteur\n");
            session.close();
		}
		return result;
	}
}

