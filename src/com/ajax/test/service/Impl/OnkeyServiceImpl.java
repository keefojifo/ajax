package com.ajax.test.service.Impl;

import java.util.List;
import java.util.Map;

import com.ajax.test.dao.OnkeyDAO;
import com.ajax.test.dao.Impl.OnkeyDAOImpl;
import com.ajax.test.service.OnkeyService;

public class OnkeyServiceImpl implements OnkeyService {
	private OnkeyDAO odao = new OnkeyDAOImpl();
	
	@Override
	public List<String>  selectOnkeyList(Map<String, String> Onkey) {
		return odao.selectOnkeyList(Onkey);
	}

	@Override
	public Map<String, String> selectOnkey(Map<String, String> Onkey) {
		// TODO Auto-generated method stub
		return null;
	}

}
