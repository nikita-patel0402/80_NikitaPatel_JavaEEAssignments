/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
/**
 *
 * @author root
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Optional
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();

        // Allow public pages & resources
        if (uri.endsWith("login.jsp") ||
            uri.endsWith("register.jsp") ||
            uri.endsWith("index.jsp") ||
            uri.endsWith("forgotPassword.jsp") ||
            uri.contains("LoginServlet") ||
            uri.contains("RegisterServlet") ||
            uri.contains("LogoutServlet") ||   
            uri.contains("css") ||
            uri.contains("AddToCartServlet") ||
            uri.contains("RemoveFromCartServlet") ||
            uri.contains("CheckoutServlet") ||
            uri.contains("addCategory.jsp") ||
            uri.contains("viewCategory.jsp") ||
            uri.contains("CategoryServlet") ||
            uri.contains("addProduct.jsp") ||
            uri.contains("viewProduct.jsp") ||
            uri.contains("ProductServlet") ||

            uri.contains("images")) {

            chain.doFilter(request, response);
            return;
        }

        // Allow if logged in
        if (session != null && session.getAttribute("userId") != null) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect("login.jsp");
        }
    }

    @Override
    public void destroy() {
        // Optional
    }
}
