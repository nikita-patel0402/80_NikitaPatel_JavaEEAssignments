/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Category;
import entity.Product;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author riya vesuwala
 */
@Local
public interface CRUDBeanLocal {
    public void addCategory(String categoryName);
    public void updateCategory(Integer categoryId,String categoryName);
    public void deleteCategory(Integer categoryId);
    public List<Category> getAllCategory();
    public Category getCategory(Integer categoryId);
    
    public void addProduct(String productName,Integer price,Integer stock,Integer categoryId);
    public void updateProduct(Integer productId,String productName,Integer price,Integer stock,Integer categoryId);
    public void deleteProduct(Integer productId);
    public List<Product> getAllProducts();
    public Product getProduct(Integer productId);
}
