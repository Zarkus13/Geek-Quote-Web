/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.geekquote.dao.impl;

import com.supinfo.geekquote.dao.QuoteDao;
import com.supinfo.geekquote.models.Quote;
import com.supinfo.geekquote.persistence.JpaDaoUtils;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alexis
 */
public class JpaQuoteDao extends JpaDaoUtils implements QuoteDao {

    public JpaQuoteDao(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public List<Quote> findAll() {
        return emf.createEntityManager().createNamedQuery("findAllQuotes").getResultList();
    }

    @Override
    public Long add(Quote quote) {
        return withTransaction(em -> {
            em.persist(quote); 
            
            return quote.getId();
        });
    }
    
}
