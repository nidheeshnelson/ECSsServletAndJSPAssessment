package org.nidheeshnelson.servletassessment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.nidheeshnelson.servletassessment.model.OrderModel;

public class OrderDao 
{
	private Connection connection;
	private static final String INSERT_ORDER_SQL = "INSERT INTO `order` (productID, username, productName, netPrice, quantity, totalAmount) " +
            										"VALUES (?, ?, ?, ?, ?, ?)";
	private static final String DELETE_ORDER_SQL = "DELETE FROM order WHERE productID = ? AND username = ?";
	private static final String COUNT_ORDER = "SELECT COUNT(*) FROM order WHERE productID = ? AND username = ?";
	private static final String SELECT_ORDERS_BY_USERNAME = "SELECT * FROM `order` WHERE username = ?";
	
	public OrderDao(Connection connection)
	{
		this.connection = connection;
	}
	
	public String insertOrderTable(OrderModel orderModel)
    {
    	try 
    	{
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL);
    				preparedStatement.setLong(1, orderModel.getProductID());
    				preparedStatement.setString(2, orderModel.getUsername());
    				preparedStatement.setString(3, orderModel.getProductName());
    				preparedStatement.setDouble(4, orderModel.getNetPrice());
    				preparedStatement.setInt(5, orderModel.getQuantity());
    				preparedStatement.setDouble(6, orderModel.getTotalAmount());
    				preparedStatement.executeUpdate();
    		return "Success Order";
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    		return "Error Occured Order";
    	}
    }
	
	public List<OrderModel> getOrderTable(String userName)
    {
		List<OrderModel> listOfOrderModel = new ArrayList<>();
		System.out.println("in getOrderTable()");
    	try 
    	{
    		System.out.println("in getOrderTable()try()");
    		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_BY_USERNAME);
    		preparedStatement.setString(1, userName);
    		ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) 
            {
                OrderModel orderModel = new OrderModel();
                orderModel.setProductID(resultSet.getLong("productID"));
                orderModel.setUsername(resultSet.getString("username"));
                orderModel.setProductName(resultSet.getString("productName"));
                orderModel.setNetPrice(resultSet.getDouble("netPrice"));
                orderModel.setQuantity(resultSet.getInt("quantity"));
                orderModel.setTotalAmount(resultSet.getDouble("totalAmount"));
                listOfOrderModel.add(orderModel);
            }
        } 
    	catch (Exception e) 
    	{
            e.printStackTrace();
        }
        return listOfOrderModel;
    }

	
//	public String deleteOrderTable(long productID, String username)
//    {
//    	try 
//    	{
//    		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_SQL);
//    				preparedStatement.setLong(1, productID);
//    				preparedStatement.setString(2, username);
//    				preparedStatement.executeUpdate();
//    		return "Success delete Order";
//    	}
//    	catch(Exception e)
//    	{
//    		System.out.println(e);
//    		return "Error Occured delete Order";
//    	}
//    }
//	
//	public int getOrderCount(long productId, String username) 
//	{
//        int count = 0;
//        try {
//             PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ORDER);
//             preparedStatement.setLong(1, productId);
//             preparedStatement.setString(2, username);
//             
//             try (ResultSet resultSet = preparedStatement.executeQuery()) 
//             {
//                if (resultSet.next()) 
//                {
//                    count = resultSet.getInt(1); 
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return count;
//    }
}
