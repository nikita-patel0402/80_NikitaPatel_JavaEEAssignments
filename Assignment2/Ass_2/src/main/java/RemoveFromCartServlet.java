import model.CartItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));

        HttpSession session = request.getSession();
        ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");

        if (cart != null) {
            cart.removeIf(item -> item.getProductId() == productId);
        }

        response.sendRedirect("cart.jsp");
    }
}
