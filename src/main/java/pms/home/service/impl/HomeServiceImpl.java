package pms.home.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import pms.home.service.BusinessVO;
import pms.home.service.HomeService;

@Service("homeService")
public class HomeServiceImpl extends EgovAbstractServiceImpl implements HomeService {
	
	@Resource(name = "homeMapper")
	private HomeMapper homeMapper;
	
	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	@Override
	public List<BusinessVO> selectBusinessList(BusinessVO businessVO) throws Exception{
		return homeMapper.selectBusinessList(businessVO);
	}
	
}
