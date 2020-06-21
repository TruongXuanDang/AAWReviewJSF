package com.demo.dao;

import com.demo.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Stateless
public class UserDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public UserDAO() {
    }

    public void insertUser(User p)
    {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public List<User> getUser()
    {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<User> list = em.createQuery("SELECT c from User c", User.class).getResultList();

        em.getTransaction().commit();
        em.close();
        return list;
    }
}
