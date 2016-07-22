package tools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Hccourse;
import model.Hcinstructor;
import model.Hcsection;
import model.Hcstudent;
import model.Hcuser;

public class DBFunctions {
	
	public static void update(Hcstudent student) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(student);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	public static void update(Hcuser user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	public static void update(Hcsection section) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(section);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	public static void insert(Hcstudent student) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(student);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	public static void insert(Hcuser user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	public static void update(Hcinstructor instructor) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(instructor);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	public static List<Hccourse> getCatalog(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select c from Hccourse c";
        
        List<Hccourse> courses = null;
        try{
            TypedQuery<Hccourse> query = em.createQuery(qString,Hccourse.class);
            courses = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return courses;
    }
	
	public static Hccourse getCourseById(String courseid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Hccourse course = null;
        String qString = "select c from Hccourse c where c.courseid = :courseid";
        try{
            TypedQuery<Hccourse> query = em.createQuery(qString,Hccourse.class);
            query.setParameter("courseid", Long.parseLong(courseid));
            course = query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return course;    
    }
	
	public static Hcsection getSectionById(String crn)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Hcsection course = null;
        String qString = "select s from Hcsection s where s.crn = :crn";
        try{
            TypedQuery<Hcsection> query = em.createQuery(qString,Hcsection.class);
            query.setParameter("crn", Long.parseLong(crn));
            course = query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return course;    
    }
	
	public static Hcuser getUserByEmail(String email)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Hcuser user = null;
        String qString = "select u from Hcuser u where u.email = :email";
        try{
            TypedQuery<Hcuser> query = em.createQuery(qString,Hcuser.class);
            query.setParameter("email", email);
            user = query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return user;    
    }
}
