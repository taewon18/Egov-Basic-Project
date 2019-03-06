package pms.home.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.rte.fdl.property.EgovPropertyService;
import pms.home.service.BusinessVO;
import pms.home.service.HomeService;

@Controller
@RequestMapping(value="/pms/home")
public class HomeController {
	
	@Resource(name = "homeService")
	private HomeService homeService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	@RequestMapping(value="/index.do")
	public String main(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		BusinessVO businessVO = new BusinessVO();
		
		List<BusinessVO> businessList = homeService.selectBusinessList(businessVO);
		
		req.setAttribute("businessList", businessList);
		
		return "/pms/home/index";
	}
}
