package me.nomurahiroshi.inventorymanagementservlet.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;
import me.nomurahiroshi.inventorymanagementservlet.model.ReadLogic;

import java.io.IOException;
import java.util.List;

@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReadLogic bo = new ReadLogic();
        List<Item> itemList = (List<Item>)bo.execute();
        request.setAttribute("itemList", itemList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/read.jsp");
        dispatcher.forward(request, response);
    }
}
