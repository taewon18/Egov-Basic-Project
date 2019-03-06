package pms.login.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PmsInterceptor extends HandlerInterceptorAdapter{
	
	List<String> urls;
	 
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler ) throws Exception{
		
		for(int i=0; i < urls.size(); i++){
            if (req.getRequestURI().matches(urls.get(i))) {
//	            System.out.println("== 인증 체크가 필요 없는 URL ============================");
//	            System.out.println("== URL : "+ urls.get(i) +" ============================");
//	            System.out.println("== return true ============================");
//	            System.out.println("== 인터셉터 종료 ============================");
	            return true;
            }
     
	        // 첫페이지가 로그인 페이지일 경우
	        // 첫페이지 jsession때문에 request.getRequestURI().indexOf("/login/login.do") != -1 사용
	        if(req.getRequestURI().indexOf(urls.get(i)) != -1){
	        	return true;
	        }
		}
		try {
			if(req.getSession().getAttribute("loginVO")==null){
				String url="";
				if(req.getRequestURI().startsWith("/usr")){
					url="/pms/login/needLogin.do";
				} else {
					url="/pms/login/needLogin.do";
				}
				res.sendRedirect(req.getContextPath()+url);
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return super.preHandle(req, res, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler ,ModelAndView modelAndView) throws Exception {
		super.postHandle(req, res, handler, modelAndView);
	}
}
