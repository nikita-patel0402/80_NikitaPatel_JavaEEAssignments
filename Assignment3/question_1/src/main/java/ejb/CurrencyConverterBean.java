/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import Entity.Conversionrate;
import Entity.Currency;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author riya vesuwala
 */
@Stateless
public class CurrencyConverterBean implements CurrencyConverterBeanLocal {
    @PersistenceContext(unitName="jpu")
    EntityManager em;
    
    @Override
    public double convert(String from, String to, double amount) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Query query=em.createQuery("select c from Conversionrate c where c.fromCurrency=:f and c.toCurrency=:t",Conversionrate.class);
        
        Currency fromCur =
        em.find(Currency.class, from);

        Currency toCur =
        em.find(Currency.class, to);
        
        query.setParameter("f",fromCur);
        query.setParameter("t", toCur);
                
        Conversionrate rate=(Conversionrate)query.getSingleResult();
        
        return amount*rate.getRate();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
