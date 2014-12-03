/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.geekquote.persistence;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alexis
 */
public class JpaDaoUtils {
    
    protected EntityManagerFactory emf;
    
    protected JpaDaoUtils(final EntityManagerFactory emf) {
        this.emf = emf;
    }
}
