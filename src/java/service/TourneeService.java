/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.Tournee;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import orm.HibernateUtil;

/**
 *
 * @author Rabab
 */
@Named(value = "tourneeService")
@Dependent
public class TourneeService  implements Serializable{

    private static final long serialVersionUID = 1L;
	Session session=null;
    public TourneeService() {
    }
    
    public ArrayList<Tournee> getAllTournee(){
        ArrayList<Tournee> allTournee = new ArrayList<>();
        try {
		this.session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		Query req = session.createQuery("from Tournee t order by t.numero");
            allTournee = (ArrayList<Tournee>) req.list();
            tx.commit();
            //session.clear();
		} catch (HibernateException e) {
		  System.out.println("Erreur dans getAllTournee\n"+e);
		}
        return allTournee;
    }
    
    
    
    
    public ArrayList<Tournee> getTourneeById(Tournee tournee){
        ArrayList<Tournee> allTournee = new ArrayList<>();
        
        return allTournee;
    }
    
    
    
    public int deleteTournee(Tournee TourneeToDelete){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String strReq="delete from Tournee t where t.id=?";
            Query req = session.createQuery(strReq).setInteger(0, TourneeToDelete.getId());
            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println(" Tournee  supprimée avec succès");
            }
            //session.clear();
		} catch (Exception e) {
			System.out.println("Erreur dans deleteTournee\n"+e);
                        e.printStackTrace();
		}
		return result;
	}
	
	public int updateTournee(Tournee TourneeToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.update(TourneeToUpdate);
            tx.commit();
            if(result>0){
            	System.out.println("Tournee Mise a  jour avec succes ");
            }
            //session.clear();
		} catch (Exception e) {
			System.out.println("Erreur dans updateTournee\n"+e);
            e.printStackTrace();
		}
		return result;
	}
	
	public int addTournee(Tournee TourneeToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			//MatToUpdate.setDepartement(getDepartementByID(idDep));
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.save(TourneeToUpdate);
//			String strReq="insert into User(nom,prenom,login,password,profile,iddepartement)";
//            Query req = session.createQuery(strReq).setString(0, userToUpdate.getNom()).setString(1, userToUpdate.getPrenom()).setString(2, userToUpdate.getLogin()).setString(3, userToUpdate.getPassword()).setString(4, userToUpdate.getProfile()).setInteger(5, idDep);
//            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("Tournee Ajoutée avec succes ");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans addTournee\n"+e);
            e.printStackTrace();
            session.close();
		}
		return result;
	}
    
}
