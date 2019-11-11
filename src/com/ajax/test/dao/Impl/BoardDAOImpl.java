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

public class BoardDAOImpl implements BoardDao {

	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> board) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
		con=DBCon.getCon();
		String sql = "select*from board_info order by bi_num desc";
		ps = con.prepareStatement(sql);
		rs=ps.executeQuery();
		List<Map<String,String>>boardList=new ArrayList<>();
		while(rs.next()) {
			Map<String,String> b = new HashMap<>();
		b.put("biNum",rs.getString("bi_num"));
		b.put("biTitle",rs.getString("bi_title"));	
		b.put("credat",rs.getString("credat"));	
		b.put("cretim",rs.getString("cretim"));	
		boardList.add(b);
		}
		return boardList;
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

	@Override
	public Map<String, String> selectBoard(Map<String, String> board) {
	
		return null;
	}

	@Override
	public int insertBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		BoardDao bdao = new BoardDAOImpl();
	System.out.println(bdao.selectBoardList(null));	
	}

}
