package pms.include.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/pms/include")
public class IncludeController {
	
	@RequestMapping(value="/_head.do")
	public String head() throws Exception{
		return "/pms/include/_head";
	}
	
	@RequestMapping(value="/_footer.do")
	public String footer() throws Exception{
		return "/pms/include/_footer";
	}
}
