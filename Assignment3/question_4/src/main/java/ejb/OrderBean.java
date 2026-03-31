/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Book;
import entity.Orderdetails;
import entity.Orders;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author riya vesuwala
 */
@Stateless
public class OrderBean implements OrderBeanLocal {
    @PersistenceContext(unitName="jpu")
    EntityManager em;

    public int placeOrder(Map<Book,Integer> cart) {

        int total = 0;

        for(Map.Entry<Book,Integer> e : cart.entrySet()){
            total += e.getKey().getPrice() * e.getValue();
        }

        // ===== Save Order =====
        Orders order = new Orders();
        order.setTotalAmount(total);

        em.persist(order);
        em.flush();   // get orderId

        // ===== Save Order Details =====
        for(Map.Entry<Book,Integer> e : cart.entrySet()){

            Orderdetails od = new Orderdetails();

            od.setOrderId(order);
            od.setBookId(e.getKey());
            od.setQuantity(e.getValue());
            od.setPrice(e.getKey().getPrice());

            em.persist(od);
        }

        return order.getOrderId();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
