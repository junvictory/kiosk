package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;
import javax.sql.rowset.JoinRowSet;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.persistence.JsonStaffDAO;
import org.springframework.stereotype.Service;
@Service
public class JsonStaffServiceImpl implements JsonStaffService {

	@Inject
	private JsonStaffDAO dao;

	@Override
	public void regist(JsonStaffDTO dto) throws Exception {
		dao.create(dto);

	}

	@Override
	public JsonStaffDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void modify(JsonStaffDTO dto) throws Exception {
		dao.update(dto);

	}

	@Override
	public void remove(Integer no) throws Exception {
		dao.delete(no);

	}

	@Override
	public List<JsonStaffDTO> listAll() throws Exception {
		return dao.listAll();
	}

}