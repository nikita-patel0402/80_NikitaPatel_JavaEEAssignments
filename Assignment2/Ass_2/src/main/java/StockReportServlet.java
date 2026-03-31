/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

/**
 *
 * @author root
 */
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/StockReportServlet")
public class StockReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<String[]> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shopDB", "root", "root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT product_id, product_name, stock FROM product_master");

            while (rs.next()) {
                String[] row = new String[3];
                row[0] = rs.getString("product_id");
                row[1] = rs.getString("product_name");
                row[2] = rs.getString("stock");
                list.add(row);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("stockList", list);
        request.getRequestDispatcher("stockReport.jsp")
               .forward(request, response);
    }
}