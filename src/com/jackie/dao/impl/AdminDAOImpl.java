package com.jackie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jackie.bean.Admin;
import com.jackie.dao.AdminDAO;
import com.jackie.util.DBCon;

public class AdminDAOImpl implements AdminDAO {
	private DBCon dbc=null;

	@Override
	public int addAdmin(Admin admin) {
		dbc =new DBCon();
		String sql="insert into admin value(?,?)";
		int res=dbc.doUpdate(sql, new Object[] {admin.getUsername(),admin.getPass()});
		dbc.close();
		return res;
	}

	@Override
	public int delAdmin(int id) {
		return 0;
	}

	@Override
	public int updateAdmin(Admin admin) {
		return 0;
	}

	@Override
	public List<Admin> findAdmins() {
		List<Admin> admins = new ArrayList<>();
		String sql="select * from admin ";
		dbc=new DBCon();
		ResultSet res=dbc.doQuery(sql, new Object[] {});
		try {
			while (res.next()) {
				Admin admin=new Admin();
				admin.setId(res.getInt("id"));
				admin.setUsername(res.getString("username"));
				admin.setPass(res.getString("pass"));
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}

	@Override
	public Admin findById(int id) {
		return null;
	}

}