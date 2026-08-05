package me.nomurahiroshi.inventorymanagementservlet.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.nomurahiroshi.inventorymanagementservlet.bo.GetSupplierLogic;
import me.nomurahiroshi.inventorymanagementservlet.bo.SelectItemLogic;
import me.nomurahiroshi.inventorymanagementservlet.bo.UpdateItemLogic;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;
import me.nomurahiroshi.inventorymanagementservlet.model.Search;
import me.nomurahiroshi.inventorymanagementservlet.model.Supplier;

import java.io.IOException;
import java.util.List;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String itemCode = request.getParameter("itemCode");
        SelectItemLogic selectItemLogic = new SelectItemLogic();
        Item item = selectItemLogic.execute(itemCode);
        request.setAttribute("item", item);

        GetSupplierLogic getSupplierLogic = new GetSupplierLogic();
        List<Supplier> supplierList = getSupplierLogic.execute();
        request.setAttribute("supplierList", supplierList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/update.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String itemCode = request.getParameter("itemCode");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int stockNum = Integer.parseInt(request.getParameter("stockNum"));
        String supplierCode = request.getParameter("supplierCode");
        Item item = new Item(itemCode, name, price, stockNum, supplierCode);
        HttpSession session = request.getSession();
        Search search = (Search)session.getAttribute("search");
        UpdateItemLogic bo = new UpdateItemLogic();
        List<Item> itemList = bo.execute(item, search);
        request.setAttribute("itemList", itemList);
        String msg = "商品を1件編集しました。";
        request.setAttribute("Msg", msg);
        if (search != null) {
            request.setAttribute("keyword", search.getKeyword());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/read.jsp");
        dispatcher.forward(request, response);
    }
}