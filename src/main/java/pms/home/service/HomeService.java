package pms.home.service;

import java.util.List;

public interface HomeService {
	List<BusinessVO> selectBusinessList(BusinessVO businessVO) throws Exception;
}
