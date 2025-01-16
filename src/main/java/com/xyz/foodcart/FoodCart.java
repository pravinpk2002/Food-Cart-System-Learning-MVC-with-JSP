package com.xyz.foodcart;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// controller
@WebServlet("/FoodCart")
public class FoodCart extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get the data from the database(model)
		String[] items = {"biryani","pizza","burger","pav bhaji"};
		req.setAttribute("items", items);
		
		 List<Food> foodItems = FoodCartDbUtil.getFoodList();
		 req.setAttribute("foodItems", foodItems);
		
		// redirect to a different page (view)
		RequestDispatcher dispatcher = req.getRequestDispatcher("show-food.jsp");
		
		dispatcher.forward(req, resp);
	}

}
