package me.nomurahiroshi.inventorymanagementservlet.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.nomurahiroshi.inventorymanagementservlet.bo.ReadItemLogic;
import me.nomurahiroshi.inventorymanagementservlet.bo.SearchItemLogic;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;
import me.nomurahiroshi.inventorymanagementservlet.model.Search;

import java.io.IOException;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Search search = (Search)session.getAttribute("search");
        if (search != null) {
            String order = search.getOrder();
            String keyword = search.getKeyword();
            SearchItemLogic bo = new SearchItemLogic();
            List<Item> itemList = bo.execute(order, keyword);
            request.setAttribute("itemList", itemList);
            request.setAttribute("keyword", keyword);
        } else {
            ReadItemLogic bo = new ReadItemLogic();
            List<Item> itemList = (List<Item>)bo.execute();
            request.setAttribute("itemList", itemList);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/read.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String order = request.getParameter("order");
        String keyword = request.getParameter("keyword");
        SearchItemLogic bo = new SearchItemLogic();
        List<Item> itemList = bo.execute(order, keyword);
        request.setAttribute("itemList", itemList);
        request.setAttribute("keyword", keyword);

        HttpSession session = request.getSession();
        Search search = new Search(order, keyword);
        session.setAttribute("search", search);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/read.jsp");
        dispatcher.forward(request, response);
    }
}
