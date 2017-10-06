package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.JsonGelleryDTO;
import org.springframework.stereotype.Repository;

@Repository
public class JsonGelleryDAOImpl implements JsonGelleryDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.kiosk.mapper.JsonGelleryMapper";
<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/persistence/JsonGelleryDAOImpl.java
	@Override
	public void create(JsonGelleryDTO dto) throws Exception {
		session.insert(namespace + ".create", dto);
		
	}
=======
//	@Override
//	public void create(JsonGelleryDTO dto) throws Exception {
//		session.insert(namespace + ".create", dto);
//		
//	}
>>>>>>> c718f6c0b276656d7d57c48609db55c599051672:ki_project/src/main/java/org/kiosk/persistence/JsonGelleryDAOImpl.java
	@Override
	public JsonGelleryDTO read(Integer no) throws Exception {
		return session.selectOne(namespace + ".read", no);
	}
	@Override
	public void update(JsonGelleryDTO dto) throws Exception {
		session.update(namespace + ".update", dto);
		
		
	}
	@Override
	public void delete(Integer no) throws Exception {
		session.delete(namespace + ".delete", no);
		
	}
	@Override
	public List<JsonGelleryDTO> listAll(String section_cd) throws Exception {
		return session.selectList(namespace + ".list",section_cd);
	}

}
