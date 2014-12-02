/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.geekquote.rest;

import com.supinfo.geekquote.dao.QuoteDao;
import com.supinfo.geekquote.models.Quote;
import com.supinfo.geekquote.persistence.DaoFactory;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alexis
 */
@Path("/quotes")
public class QuotesRest {
    
    private QuoteDao quoteDao = DaoFactory.getQuoteDao();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Quote> listAll() {
        return quoteDao.findAll();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Long addQuote(Quote quote) {
        return quoteDao.add(quote);
    }
    
}
