/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Book;
import jakarta.ejb.Local;
import java.util.Map;

/**
 *
 * @author riya vesuwala
 */
@Local
public interface OrderBeanLocal {
    public int placeOrder(Map<Book,Integer> cart);
}
