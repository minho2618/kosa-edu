package com.jdbc.test;

import java.sql.SQLException;

import com.jdbc.dao.ProductDAO;

import config.ServerInfo;

public class ProductDAOTest {

	public static void main(String[] args) {
		try {
			new ProductDAO();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading...Success");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
