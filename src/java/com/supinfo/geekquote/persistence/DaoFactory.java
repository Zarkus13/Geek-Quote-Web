/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.geekquote.persistence;

import com.supinfo.geekquote.dao.QuoteDao;
import com.supinfo.geekquote.dao.impl.JpaQuoteDao;

/**
 *
 * @author alexis
 */
public class DaoFactory {
    
    private DaoFactory() {}
    
    public static QuoteDao getQuoteDao() {
        return new JpaQuoteDao(PersistenceManager.getEntityManagerFactory());
    }
    
}
