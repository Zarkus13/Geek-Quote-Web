/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.geekquote.persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alexis
 */
public class PersistenceManager {
    
    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            Properties envs = System.getProperties();
            Map<String, Object> config = new HashMap<>();
            
            config.put("javax.persistence.jdbc.url", 
                    envs.getProperty("MYSQL_ADDON_HOST", "jdbc:mysql://localhost:3306") 
                        + "/" + envs.getProperty("MYSQL_ADDON_DB", "geekquote"));
            
            config.put("javax.persistence.jdbc.user", envs.getProperty("MYSQL_ADDON_USER", "java"));
            config.put("javax.persistence.jdbc.password", envs.getProperty("MYSQL_ADDON_PASSWORD", "java"));
            
//            for(String k : envs.keySet()) {
//                if(k.equalsIgnoreCase("MYSQL_ADDON_HOST"))
//                    config.put("javax.persistence.jdbc.url", envs.get(k) + "/" + envs.get("MYSQL_ADDON_DB"));
//                else if(k.equalsIgnoreCase("MYSQL_ADDON_USER"))
//                    config.put("javax.persistence.jdbc.user", envs.get(k));
//                else if(k.equalsIgnoreCase("MYSQL_ADDON_PASSWORD"))
//                    config.put("javax.persistence.jdbc.password", envs.get(k));
//            }
            
            emf = Persistence.createEntityManagerFactory("GeekQuotePU", config);
        }

        return emf;
    }
    
    public static void closeEntityManagerFactory() {
        if(emf != null && emf.isOpen())
            emf.close();
    }
    
}
