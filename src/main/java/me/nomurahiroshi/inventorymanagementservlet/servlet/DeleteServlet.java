package me.nomurahiroshi.inventorymanagementservlet.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.nomurahiroshi.inventorymanagementservlet.bo.DeleteItemLogic;
import me.nomurahiroshi.inventorymanagementservlet.bo.GetSupplierLogic;
import me.nomurahiroshi.inventorymanagementservlet.bo.SelectItemLogic;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;
import me.nomurahiroshi.inventorymanagementservlet.model.Search;
import me.nomurahiroshi.inventorymanagementservlet.model.Supplier;

import java.io.IOException;
import java.util.List;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String itemCode = request.getParameter("itemCode");
        SelectItemLogic selectItemLogic = new SelectItemLogic();
        Item item = selectItemLogic.execute(itemCode);
        request.setAttribute("item", item);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/deleteConfirm.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String itemCode = request.getParameter("itemCode");
        HttpSession session = request.getSession(false);
        Search search = (Search)session.getAttribute("search");
        DeleteItemLogic bo = new DeleteItemLogic();
        List<Item> itemList = bo.execute(itemCode, search);
        request.setAttribute("itemList", itemList);
        String msg = "商品を1件削除しました。";
        request.setAttribute("Msg", msg);
        if (search != null) {
            request.setAttribute("keyword", search.getKeyword());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/read.jsp");
        dispatcher.forward(request, response);
    }
}
