package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.persistence.MateDAO;
import org.springframework.stereotype.Service;
@Service
public class MateServiceImpl implements MateService {
	@Inject
	private MateDAO dao;

//	@Override
//	public void regist(MateDTO dto) throws Exception {
//		dao.create(dto);
//		
//	}

	@Override
	public MateDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void modify(MateDTO dto) throws Exception {
		dao.update(dto);
		
	}

	@Override
	public void remove(Integer no) throws Exception {
		dao.delete(no);
		
	}

	@Override
	public List<MateDTO> list(TeamsDTO dto) throws Exception {
		return dao.list(dto); 
	}

}
