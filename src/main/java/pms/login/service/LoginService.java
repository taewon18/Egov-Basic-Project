package pms.login.service;

import java.util.List;

import pms.home.service.BusinessVO;

public interface LoginService {
	List<BusinessVO> selectBusinessList(BusinessVO businessVO) throws Exception;
	
}
