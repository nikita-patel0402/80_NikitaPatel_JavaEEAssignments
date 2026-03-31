package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import ejb.CRUDBeanLocal;
import entity.Category;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author riya vesuwala
 */
@WebServlet(urlPatterns = {"/CategoryServlet"})
public class CategoryServlet extends HttpServlet {
    @EJB 
    CRUDBeanLocal CrudBean;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CategoryServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoryServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        if("update".equals(action))
        {
            Integer cid=Integer.parseInt(request.getParameter("categoryId"));
            Category category=CrudBean.getCategory(cid);
            request.setAttribute("category",category);
            System.out.println("Data Fetched");
        }
        if("delete".equals(action))
        {
            Integer id=Integer.parseInt(request.getParameter("categoryId"));
            CrudBean.deleteCategory(id);
            System.out.println("Data Deleted");
        }
        request.setAttribute("categoryList", CrudBean.getAllCategory());
        request.getRequestDispatcher("Category.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        System.out.println(action);
        if("add".equals(action))
        {
            String categoryName=request.getParameter("categoryName");
            CrudBean.addCategory(categoryName);
            System.out.println("Data Added");
        }
        
        if("edit".equals(action))
        {
            Integer id=Integer.parseInt(request.getParameter("categoryId"));
            String name=request.getParameter("categoryName");
            CrudBean.updateCategory(id, name);
            System.out.println("Data Updated");
        }
        response.sendRedirect("CategoryServlet");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
