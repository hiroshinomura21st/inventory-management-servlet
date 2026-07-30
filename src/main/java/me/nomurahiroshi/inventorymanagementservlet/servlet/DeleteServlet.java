package me.nomurahiroshi.inventorymanagementservlet.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.nomurahiroshi.inventorymanagementservlet.bo.DeleteItemLogic;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;

import java.io.IOException;
import java.util.List;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String itemCode = request.getParameter("itemCode");
        DeleteItemLogic bo = new DeleteItemLogic();
        List<Item> itemList = bo.execute(itemCode);
        request.setAttribute("itemList", itemList);
        String Msg = "商品を1件削除しました。";
        request.setAttribute("Msg", Msg);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/read.jsp");
        dispatcher.forward(request, response);
    }
}
