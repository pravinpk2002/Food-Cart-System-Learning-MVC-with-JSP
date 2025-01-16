package com.xyz.foodcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FoodCartDbUtil {
	
	public static List<Food> getFoodList(){
		
		String url = "jdbc:mysql://localhost:3306/food";
		String userName = "root";
		String password = "rootlogin";
		
		ArrayList<Food> foods = new ArrayList<>();
		
		// load mysql driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//get the connection
			Connection con = DriverManager.getConnection(url, userName, password);
			
			//create a statment
			Statement stmt = con.createStatement();
			
			String query = "select * from foodcart";
			
			//execute the statement and loop over the result set
			 ResultSet rs = stmt.executeQuery(query);
			
			 
			 while( rs.next()) {
				 int id = rs.getInt(1);
				 String item = rs.getString(2);
				 double price = rs.getDouble(3);
				 
				 Food food = new Food(id, item, price);
				 
				 foods.add(food);
				 
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(foods.get(0).getId() + " "+foods.get(0).getItem()+" "+foods.get(0).getPrice());
		
		return foods;
	}

}
