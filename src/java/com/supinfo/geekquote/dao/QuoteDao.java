/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.geekquote.dao;

import com.supinfo.geekquote.models.Quote;
import java.util.List;

/**
 *
 * @author alexis
 */
public interface QuoteDao {
    
    public List<Quote> findAll();
    
    public Long add(final Quote quote);
    
}
