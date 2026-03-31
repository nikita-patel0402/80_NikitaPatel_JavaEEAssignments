/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Category;
import entity.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author riya vesuwala
 */
@Stateless
public class CRUDBean implements CRUDBeanLocal {
    @PersistenceContext(unitName="jpu")
    EntityManager em;
    
    @Override
    public void addCategory(String categoryName) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try{
            Category category=new Category();
            category.setCategoryName(categoryName);
            em.persist(category);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategory(Integer categoryId, String categoryName) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Category category=em.find(Category.class, categoryId);
        
        if(category!=null)
        {
            category.setCategoryName(categoryName);
            em.merge(category);
        }
        
    }

    @Override
    public void deleteCategory(Integer categoryId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Category category=em.find(Category.class, categoryId);
        
        if(category!=null)
        {
            em.remove(category);
        }
    }

    @Override
    public List<Category> getAllCategory() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createQuery("select c from Category c",Category.class).getResultList();
    }

    @Override
    public Category getCategory(Integer categoryId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return (Category)em.createQuery("select c from Category c where c.categoryId=:id").setParameter("id",categoryId).getSingleResult();
    }

    @Override
    public void addProduct(String productName, Integer price, Integer stock, Integer categoryId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try{
            Product product=new Product();
            product.setProductName(productName);
            product.setPrice(price);
            product.setStock(stock);
            
            Category category=em.find(Category.class, categoryId);
            
            product.setCategoryId(category);   
            em.merge(product);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Integer productId, String productName, Integer price, Integer stock, Integer categoryId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Product product=em.find(Product.class, productId);
        
        if(product!=null)
        {
            product.setProductName(productName);
            product.setPrice(price);
            product.setStock(stock);
            
            Category category=em.find(Category.class, categoryId);
            
            product.setCategoryId(category);   
            em.persist(product);
        }
    }

    @Override
    public void deleteProduct(Integer productId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Product product=em.find(Product.class, productId);
        
        if(product!=null)
        {
            em.remove(product);
        }
    }

    @Override
    public List<Product> getAllProducts() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createQuery(
            "SELECT p FROM Product p JOIN FETCH p.categoryId",
            Product.class
        ).getResultList();
    }

    @Override
    public Product getProduct(Integer productId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return (Product)em.createQuery("select p from Product p JOIN FETCH p.categoryId WHERE p.productId=:id").setParameter("id", productId).getSingleResult();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
