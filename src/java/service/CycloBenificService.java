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
import model.Benificiaire;
import model.CycloBenificiaire;
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
@Named("CBService")
public class CycloBenificService    implements Serializable{
    
    private static final long serialVersionUID = 1L;
	Session session=null;

    public CycloBenificService  () {
    }
        
        
        
    public ArrayList<CycloBenificService > getAllCycloB(){
        ArrayList<CycloBenificService > AllCycloB = new ArrayList<>();
        try {
		this.session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction tx = session.beginTransaction();
		Query req = session.createQuery("from Benificiaire b order by b.nom");
          AllCycloB = (ArrayList<CycloBenificService >) req.list();
            tx.commit();
            //session.clear();
		} catch (HibernateException e) {
		  System.out.println("Erreur dans getAllCyclo\n"+e);
		}
        return AllCycloB;
    }
    
    
    
  
    
    public int deleteBenific(CycloBenificiaire  CBToDelete){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String strReq="delete from Benificiaire b where b.id=?";
            Query req;
                    req = session.createQuery(strReq).setInteger(0, CBToDelete.getId());
            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("cyclo benificiaire supprimée avec succès");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans deleteCycloB\n"+e);
		}
		return result;
	}
	
	public int updateBl(CycloBenificiaire  BenificToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.update(BenificToUpdate);
            tx.commit();
            if(result>0){
            	System.out.println("cyclob ajouté avec succes");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans updateMat\n"+e);
		}
		return result;
	}
	
    /**
     *
     * @param CyclobToUpdate
     * @param BenificToUpdate
     * @return
     */
    public int addCycloB(CycloBenificiaire CyclobToUpdate){
		int result=0;
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			//MatToUpdate.setDepartement(getDepartementByID(idDep));
			if(!session.isOpen()){
				session=HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			}
			session.save(CyclobToUpdate);
//			String strReq="insert into User(nom,prenom,login,password,profile,iddepartement)";
//            Query req = session.createQuery(strReq).setString(0, userToUpdate.getNom()).setString(1, userToUpdate.getPrenom()).setString(2, userToUpdate.getLogin()).setString(3, userToUpdate.getPassword()).setString(4, userToUpdate.getProfile()).setInteger(5, idDep);
//            result= req.executeUpdate();
            tx.commit();
            if(result>0){
            	System.out.println("MatÃ©iel AjoutÃ© avec succÃ¨s");
            }
            //session.clear();
		} catch (HibernateException e) {
			System.out.println("Erreur dans addbenific\n"+e);
            session.close();
		}
		return result;
	}
}