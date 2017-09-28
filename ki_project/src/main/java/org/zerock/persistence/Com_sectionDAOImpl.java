package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.Com_sectionVO;

@Repository
public class Com_sectionDAOImpl implements Com_sectionDAO{

	@Inject
	private SqlSession session;

	private static String namespace = "org.zerock.mapper.Com_sectionMapper";

	@Override
	public void create(Com_sectionVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
		
	}

	@Override
	public Com_sectionVO read(String section_cd) throws Exception {
		return session.selectOne(namespace + ".read", section_cd);
	}

	@Override
	public void update(Com_sectionVO vo) throws Exception {
		session.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(String section_cd) throws Exception {
		session.delete(namespace + ".delete", section_cd);
		
	}

	@Override
	public List<Com_sectionVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
