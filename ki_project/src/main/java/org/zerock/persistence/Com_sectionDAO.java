package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.Com_sectionVO;

public interface Com_sectionDAO {
	  public void create(Com_sectionVO vo) throws Exception;

	  public Com_sectionVO read(String section_cd) throws Exception;

	  public void update(Com_sectionVO vo) throws Exception;

	  public void delete(String section_cd) throws Exception;

	  public List<Com_sectionVO> listAll() throws Exception;
}
