package me.nomurahiroshi.inventorymanagementservlet.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.nomurahiroshi.inventorymanagementservlet.bo.CreateLogic;
import me.nomurahiroshi.inventorymanagementservlet.bo.GetSupplierLogic;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;
import me.nomurahiroshi.inventorymanagementservlet.model.Supplier;

import java.io.IOException;
import java.util.List;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetSupplierLogic bo = new GetSupplierLogic();
        List<Supplier> supplierList = bo.execute();
        request.setAttribute("supplierList", supplierList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/create.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String itemCode = request.getParameter("itemCode");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int stockNum = Integer.parseInt(request.getParameter("stockNum"));
        String supplierCode = request.getParameter("supplierCode");

        Item item = new Item(itemCode, name, price, stockNum, supplierCode);
        CreateLogic bo = new CreateLogic();
        List<Item> itemList = bo.execute(item);
        request.setAttribute("itemList", itemList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/read.jsp");
        dispatcher.forward(request, response);
    }
}
