package pms.login.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import pms.home.service.BusinessVO;
import pms.login.service.LoginService;

@Service("loginService")
public class LoginServiceImpl extends EgovAbstractServiceImpl implements LoginService {
	
	@Resource(name = "loginMapper")
	private LoginMapper loginMapper;
	
	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	@Override
	public List<BusinessVO> selectBusinessList(BusinessVO businessVO) throws Exception{
		return loginMapper.selectBusinessList(businessVO);
	}
	
	
}
