package pms.login.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import pms.home.service.BusinessVO;

@Mapper("loginMapper")
public interface LoginMapper {
	/**
	 * 회사목록을 조회
	 * @param BusinessVO
	 * @return
	 * @throws Exception
	 */
	List<BusinessVO> selectBusinessList(BusinessVO vo) throws Exception;
	
}
