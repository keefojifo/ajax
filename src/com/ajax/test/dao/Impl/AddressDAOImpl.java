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
import com.ajax.test.dao.AddressDAO;

public class AddressDAOImpl implements AddressDAO {

	@Override
	public List<Map<String, String>> selectSidoList(Map<String, String> sido) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select* from sido";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Map<String, String>> sidoList = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("sNum", rs.getString("s_Num"));
				map.put("sName", rs.getString("s_Name"));
				sidoList.add(map);

			}
			return sidoList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					con.close();
				}

				if (ps != null) {
					con.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Map<String, String> selectSido(Map<String, String> sido) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		AddressDAO adao = new AddressDAOImpl();
		System.out.println(adao.selectSidoList(null));

	}

}
