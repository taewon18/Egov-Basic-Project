package pms.login.web;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pms.login.service.LoginService;

@Controller
@RequestMapping(value="/pms/login")
public class LoginController {
	
	private String mainPath = "/pms/login/";
	
	@Resource(name = "loginService")
	private LoginService loginService;
	
	
	@RequestMapping(value="/login.do")
	public String login(HttpServletRequest request) throws Exception{
		request.getSession().removeAttribute("loginVO");
		request.getSession().invalidate();
		
		return "/pms/login/login";
	}
	
	@RequestMapping(value="/loginProcess.do")
	public String loginProcess(HttpSession session, HttpServletRequest req, HttpServletResponse response) throws Exception{
    		
		/*
		if ( req.getSession().getAttribute("loginVO") != null ){
            // 기존에 login이란 세션 값이 존재한다면
            req.getSession().removeAttribute("loginVO"); // 기존값을 제거해 준다.
        }
        
        response.setContentType("text/html; charset=UTF-8");       
        PrintWriter out = response.getWriter();
        
        BusinessVO dto = new BusinessVO();
        Crypto crypto = new Crypto();
        
        dto.setCompanyRegistrationNumber(req.getParameter("registNumber"));
        dto.setPasswordCrypt(crypto.encrypt(req.getParameter("password")));
        
        // 로그인이 성공하면 CompanyInfoVO 객체를 반환함.
        BusinessVO vo = loginService.idpwCheck(dto);
         
        if ( vo != null ){ // 로그인 성공
        	String useTime = "500"; 

        	CompanyInfoVO cvo = loginService.selectCompanyInfo(dto);
        	req.getSession().setAttribute("CompanyRegistrationNumber", vo.getCompanyRegistrationNumber());
        	
        	RnDRegisterInfoVO rrvo = new RnDRegisterInfoVO();		
    		rrvo = loginService.selectRnDRegisterInfo((String)req.getSession().getAttribute("CompanyRegistrationNumber"));

            req.getSession().setAttribute("loginVO", cvo);
            req.getSession().setAttribute("companyBasicInfo", vo);
            req.getSession().setAttribute("useTime", useTime);
            req.getSession().setAttribute("RnDRegisterNumber", cvo.getRnDRegisterNumber());
            req.getSession().setAttribute("rnDRegisterInfo", rrvo);
            
            out.println("<script>alert('"+cvo.getCompanyName()+" 로그인 확인');</script>");
            
            String status = rrvo.getRnDRegisterStatusCode();
            String kind = rrvo.getRnDRegisterKindCode();
            String kindType = ("1".equals(kind))?"newRegist":"registUpdate";
                		
    		if ("1".equals(status)){
    			out.println("<script>alert('가입승인 처리 중 입니다. \\\n 장기간 가입승인이 안된 경우 관리자에게 문의주시기 바랍니다.');</script>");
    			req.getSession().setAttribute("loginCheck","/pms/login/login.do");
    		} else if("10".equals(status)){ 
    			//승인상태: 변경신고체크로 이동
    			req.getSession().setAttribute("loginCheck","/pms/registGuide/registUpdate.do");
    		} else {
    			req.getSession().setAttribute("loginCheck","/pms/regist/"+kindType+"/regist.do");
    		}
            
            
             // 로그인 시 공통코드 미리 세션등록
       		 // 최종학위,직급정보, 부서 등등 등록
             
            List<CommonCodeVO> bcccVO = registUpdateService.selectCommonCode("TB_BusinessCategoryClassificationCode");
    		List<CommonCodeVO> bccVO = registUpdateService.selectCommonCode("TB_BusinessCategoryCode");
    		List<CommonCodeVO> ctcVO = registUpdateService.selectCommonCode("TB_CompanyTypeCode");
    		List<CommonCodeVO> btcVO = registUpdateService.selectCommonCode("TB_BuildingTypeCode");
    		List<CommonCodeVO> rstcVO = registUpdateService.selectCommonCode("TB_ResearchSpaceTypeCode");
    		List<CommonCodeVO> bdcVO = registUpdateService.selectCommonCode("TB_BusinessDivisionCode");
    		List<CommonCodeVO> rduicvoList = registUpdateService.selectCommonCode("TB_RnDUpdateItemCode");
    		List<CommonCodeVO> degreeCode = registUpdateService.selectCommonCode("TB_DegreeCode");
    		List<CommonCodeVO> useClassificationCode = registUpdateService.selectCommonCode("TB_UseClassificationCode");
    		
    		req.getSession().setAttribute("businessCategoryClassificationCode",bcccVO);
    		req.getSession().setAttribute("businessCategoryCode",bccVO);
    		req.getSession().setAttribute("companyTypeCode",ctcVO);
    		req.getSession().setAttribute("buildingTypeCode",btcVO);
    		req.getSession().setAttribute("researchSpaceTypeCode",rstcVO);
    		req.getSession().setAttribute("businessDivisionCode",bdcVO);
    		req.getSession().setAttribute("rnDUpdateItemCode",rduicvoList);
    		req.getSession().setAttribute("degreeCode",degreeCode);
    		req.getSession().setAttribute("useClassificationCode",useClassificationCode);
    		
        }else { // 로그인에 실패한 경우
        	out.println("<script>alert('로그인이 실패하였습니다.');</script>");
        	//response.sendRedirect("/pms/login/login.do");
        	req.getSession().setAttribute("loginCheck","/pms/login/login.do");
        	//returnURL = mainPath+"loginCheck";
        }
        out.flush(); 
        */
        return mainPath+"loginCheck"; // 위에서 설정한 returnURL 을 반환해서 이동시킴
	}
	
	
	@RequestMapping(value="/loginCheck.do")
	public String loginCheck() throws Exception{
        	//response.sendRedirect("/pms/login/login.do");
		return mainPath+"loginCheck";
	}
	
	@RequestMapping(value="/modify.do")
	public String modify() throws Exception{
		return mainPath+"modify";
	}
	
	@RequestMapping(value="/join.do")
	public String join() throws Exception{
		return mainPath+"join";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session, HttpServletRequest req, HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8");       
		PrintWriter out = response.getWriter();
		out.println("<script>alert('로그아웃 하였습니다.');</script>");
		out.flush();
		req.getSession().setAttribute("loginCheck","/pms/login/login.do");
		
		return mainPath+"loginCheck";
	}
	
	
	
	
	@RequestMapping(value="/needLogin.do")
	public String needLogin(HttpSession session, HttpServletRequest req, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");       
		PrintWriter out = response.getWriter();
		out.println("<script>alert('로그인 후 이용해 주시기 바랍니다.');</script>");
		out.flush();
		req.getSession().setAttribute("loginCheck","/pms/login/login.do");
		
		return mainPath+"loginCheck";
	}
}
