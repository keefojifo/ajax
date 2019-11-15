package com.ajax.test.service;

import java.util.List;
import java.util.Map;

public interface AddressService {
	List<Map<String, String>> selectSidoList(Map<String, String> sido);
    Map<String, String> selectSido(Map<String, String> sido);
}
