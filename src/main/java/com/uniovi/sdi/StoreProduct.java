package com.uniovi.sdi;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "ServletStoreProducts", value = "/products")
public class StoreProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductsService product =  new ProductsService();
        request.setAttribute("storeProducts", product.getProducts());
        getServletContext().getRequestDispatcher("/products-view.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
