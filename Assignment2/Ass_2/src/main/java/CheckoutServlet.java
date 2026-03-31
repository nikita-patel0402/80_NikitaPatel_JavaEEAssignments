import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import model.CartItem;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
        Integer userId = (Integer) session.getAttribute("userId");

        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shopDB", "root", "root");

            double totalAmount = 0;
            for (CartItem item : cart) {
                totalAmount += item.getTotal();
            }

            // Generate Bill No
            String billNo = "BILL" + new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO order_master(user_id, bill_no, order_datetime, total_amount, payment_mode, payment_status, order_status) VALUES (?,?,NOW(),?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, userId);
            ps.setString(2, billNo);
            ps.setDouble(3, totalAmount);
            ps.setString(4, "COD"); // You can change later
            ps.setString(5, "UNPAID");
            ps.setString(6, "PLACED");

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int orderId = rs.getInt(1);

            PreparedStatement ps2 = con.prepareStatement(
                "INSERT INTO order_details(order_id, product_id, product_price, quantity) VALUES (?,?,?,?)");

            for (CartItem item : cart) {
                ps2.setInt(1, orderId);
                ps2.setInt(2, item.getProductId());
                ps2.setDouble(3, item.getPrice());
                ps2.setInt(4, item.getQuantity());
                ps2.executeUpdate();
            }

            session.removeAttribute("cart");

            con.close();

            response.sendRedirect("bill.jsp?orderId=" + orderId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}