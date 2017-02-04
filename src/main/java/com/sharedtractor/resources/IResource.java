package com.sharedtractor.resources;

import java.sql.Connection;

import com.sharedtractor.dao.DAO;

public interface IResource {
	public static Connection conn = DAO.getConnection();
}
