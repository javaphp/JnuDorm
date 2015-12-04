package cn.jnu.dorm.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.jnu.dorm.base.BaseAction;
import cn.jnu.dorm.domain.DormInfo;
import cn.jnu.dorm.domain.Student;

@Controller
@Scope("prototype")
public class DormInfoAction extends BaseAction<DormInfo> {

	public String add() {
		dormInfoService.save(model);
		return "toList";
	}
	
	public String addUI() {
		return "saveUI";
	}
	
	public String delete() {
		DormInfo dormInfo = dormInfoService.findById(model.getId());
		dormInfoService.delete(dormInfo);
		return "toList";
	}
	
	public String edit() {
		DormInfo dormInfo = dormInfoService.findById(model.getId());
		dormInfo.setName(model.getName());
		dormInfo.setFloor(model.getFloor());
		dormInfo.setRoom(model.getRoom());
		dormInfoService.update(dormInfo);
		return "toList";
	}
	public String editUI() {
		DormInfo dormInfo = dormInfoService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(dormInfo);
		return "saveUI";
	}
	public String list() {
		List<DormInfo> dormInfoList = dormInfoService.findAll();
		ActionContext.getContext().put("dormInfoList", dormInfoList);
		return "list";
	}

}
