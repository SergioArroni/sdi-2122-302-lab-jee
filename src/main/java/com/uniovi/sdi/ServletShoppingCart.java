package com.uniovi.sdi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "ServletShoppingCart", value = "/AddToShoppingCart")
public class ServletShoppingCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<String, Integer> cart =
                (HashMap<String, Integer>) request.getSession().getAttribute("cart");
        // No hay carrito, creamos uno y lo insertamos en sesión
        if (cart == null) {
            cart = new HashMap<String, Integer>();
            request.getSession().setAttribute("cart", cart);
        }
        String product = request.getParameter("product"); if (product != null) {addToShoppingCart(cart, product);}
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Tienda SDI: Cesta de la compra</TITLE></HEAD>");
        out.println("<BODY>");
        out.println(shoppingCartToHtml(cart) + "<br>");
        //out.println("<a href=\"shop.html\">Volver</a></BODY></HTML>");
        out.println("<a href=\"index.jsp\">Volver</a></BODY></HTML>");
    }

    private void addToShoppingCart(HashMap<String, Integer> cart, String product) {
        if(cart.get(product) == null){
            cart.put(product,Integer.valueOf(1));
        }
        else {
            int productCont = (Integer) cart.get(product).intValue();
            cart.put(product,Integer.valueOf(productCont+1));
        }
    }

    private String shoppingCartToHtml(HashMap<String, Integer> cart) {
    String shoppingCardHtml="";
    for (String key: cart.keySet()){
        shoppingCardHtml += "<p>["+key+"]"+cart.get(key)+"unidades</p>";
    }
    return shoppingCardHtml;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
