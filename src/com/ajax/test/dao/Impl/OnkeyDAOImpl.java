package com.ajax.test.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.common.DBCon;
import com.ajax.test.dao.BoardDao;
import com.ajax.test.dao.OnkeyDAO;

public class OnkeyDAOImpl implements OnkeyDAO {

	@Override
	public List<String> selectOnkeyList(Map<String,String> Onkey) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBCon.getCon();
			String sql = "select * from onKey";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List< String> onkeyList = new ArrayList<>();
			while (rs.next()) {
				onkeyList.add(rs.getString("o_color"));

				System.out.println(onkeyList);
			return onkeyList;
			}
		}catch(SQLException e) {
			
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return null;
		
	}
	public static void main(String[] agrs) {
		OnkeyDAO odao = new OnkeyDAOImpl();
		System.out.println(odao.selectOnkeyList(null));
	}
	
}
