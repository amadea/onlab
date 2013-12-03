/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.ami.onlab.jobportal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Ami
 */
public class TestDB {
    public static void main(String args[]){
        
EntityManagerFactory emf = Persistence.createEntityManagerFactory("EnterpriseApplication1-ejbPU");
EntityManager em = emf.createEntityManager();


 em.getTransaction().begin();

Client teszter = new Client();
teszter.setUserName("Teszter");
teszter.setFirstName("Eszter");
teszter.setLastName("Teszt");
em.persist(teszter);

Client noname = new Client();
teszter.setUserName("noname");
teszter.setFirstName("name");
teszter.setLastName("no");
em.persist(noname);

em.getTransaction().commit();

em.close();
emf.close();
}
}


