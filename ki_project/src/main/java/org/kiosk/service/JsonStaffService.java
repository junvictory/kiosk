package org.kiosk.service;

import java.util.List;

import org.kiosk.dto.JsonStaffDTO;

public interface JsonStaffService {

	  public void regist(JsonStaffDTO dto) throws Exception;

	  public JsonStaffDTO read(Integer no) throws Exception;

	  public void modify(JsonStaffDTO dto) throws Exception;

	  public void remove(Integer no) throws Exception;
	  
	  public List<JsonStaffDTO> listAll() throws Exception;
}
