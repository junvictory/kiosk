package org.kiosk.service;

import java.util.List;

<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/service/JsonNoticeService.java
import org.kiosk.dto.JsonGelleryDTO;
=======
>>>>>>> c718f6c0b276656d7d57c48609db55c599051672:ki_project/src/main/java/org/kiosk/service/JsonNoticeService.java
import org.kiosk.dto.JsonNoticeDTO;

public interface JsonNoticeService {
	
	 // public void regist(JsonNoticeDTO dto) throws Exception;

	  public JsonNoticeDTO read(Integer no) throws Exception;

	  public void modify(JsonNoticeDTO dto) throws Exception;

	  public void remove(Integer no) throws Exception;
	  
	  public List<JsonNoticeDTO> listAll(String section_cd) throws Exception;
}
