/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.geekquote.persistence;

import java.util.function.Consumer;
import java.util.function.Function;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author alexis
 */
public class JpaDaoUtils {
    
    protected EntityManagerFactory emf;
    
    protected JpaDaoUtils(final EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    protected <T> T withTransaction(Function<EntityManager, T> function) {
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction t = em.getTransaction();
        
        T result = null;
        
        try {
            t.begin();
            
            result = function.apply(em);
            
            t.commit();
        }
        finally {
            if(t.isActive())
                t.rollback();
            
            em.close();
        }
        
        return result;
    }
}
