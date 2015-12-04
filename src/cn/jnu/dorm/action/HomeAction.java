package cn.jnu.dorm.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.jnu.dorm.base.BaseAction;

@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport {

	public String index() throws Exception {
		return "index";
	}
	
}
