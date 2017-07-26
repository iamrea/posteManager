/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.CycloFacteur;
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
@Named("CfService")
public class CycloFacteurService implements Serializable{
    
    private static final long serialVersionUID = 1L;
	Session session=null;

    public CycloFacteurService () {
    }
        
        
        
    public ArrayList<CycloFacteur > getAllCF(){
        ArrayList<CycloFacteur > allCF = new ArrayList<>();
        try {
		this.session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		Query req;
            req = session.createQuery("from CycloFacteur b order by b.id");
            allCF = (ArrayList<CycloFacteur>) req.list();
            tx.commit();
            //session.clear();
		} catch (HibernateException e) {
		  System.out.println("Erreur dans getAllBL\n"+e);
		}
        return allCF;
    }
    
    
    
    

    
    /**
     *
     * @param CFToDelete
     * @return
     */
    public int deleteCF(CycloFacteur CFToDelete){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String strReq="delete from CycliFacteur b where b.id=?";
            Query req = session.createQuery(strReq).setInteger(0, CFToDelete.getId());
            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("cyclo facteur  supprimée avec succès");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans deleteCF\n"+e);
		}
		return result;
	}
	
    /**
     *
     * @param CFToUpdate
     * @return
     */
    public int updateCF(CycloFacteur CFToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.update(CFToUpdate);
            tx.commit();
            if(result>0){
            	System.out.println("Cyclo Facteur Mis Ã  jour avec succÃ¨s avec succÃ¨s");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans updateMat\n"+e);
		}
		return result;
	}
	
	public int addCF(CycloFacteur CFToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			//MatToUpdate.setDepartement(getDepartementByID(idDep));
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.save(CFToUpdate);
//			String strReq="insert into User(nom,prenom,login,password,profile,iddepartement)";
//            Query req = session.createQuery(strReq).setString(0, userToUpdate.getNom()).setString(1, userToUpdate.getPrenom()).setString(2, userToUpdate.getLogin()).setString(3, userToUpdate.getPassword()).setString(4, userToUpdate.getProfile()).setInteger(5, idDep);
//            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Cyclo Facteur AjoutÃ© avec succÃ¨s");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans addUser\n"+e);
            session.close();
		}
		return result;
	}

    
}



