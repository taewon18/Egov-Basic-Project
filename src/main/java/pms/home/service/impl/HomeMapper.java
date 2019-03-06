package pms.home.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import pms.home.service.BusinessVO;

@Mapper("homeMapper")
public interface HomeMapper {
	/**
	 * 회사목록을 조회
	 * @param BusinessVO
	 * @return
	 * @throws Exception
	 */
	List<BusinessVO> selectBusinessList(BusinessVO businessVO) throws Exception;
}
