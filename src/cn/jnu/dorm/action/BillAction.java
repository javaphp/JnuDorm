package cn.jnu.dorm.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.jnu.dorm.base.BaseAction;
import cn.jnu.dorm.domain.Bill;
import cn.jnu.dorm.domain.DormInfo;
import cn.jnu.dorm.utils.MyConstants;

@Controller
@Scope("prototype")
public class BillAction extends BaseAction<Bill>{

	private String dormName;
	private int dormId;
	
	public String addUI() {
		List<DormInfo> buildingList = billService.findDormBuilding();
		DormInfo dorm;
		List<DormInfo> dormInfoList = new ArrayList<DormInfo>();
		for (int i=0;i<buildingList.size();i++) {
			dorm = new DormInfo();
			dorm.setName(buildingList.get(i) + "");
			dormInfoList.add(dorm);
		}
		ActionContext.getContext().put("dormInfoList", dormInfoList);
		System.out.println("building:" + buildingList.get(0));
		return "saveUI";
	}
	
	public String save() throws Exception {
		Bill bill = new Bill();

		bill.setYearMonth(model.getYearMonth());
		bill.setWater((float)model.getWater());
		bill.setElectricity(model.getElectricity());
		bill.setWaterPrice(model.getWaterPrice());
		bill.setElectricityPrice(model.getElectricityPrice());
		double shouldPay = MyConstants.waterPrice * model.getWater() + 
						MyConstants.electricityPrice * model.getElectricity();
		bill.setShouldPay(shouldPay);
		DormInfo dormInfo = dormInfoService.findById(dormId);
		bill.setDormInfo(dormInfo);
		
		billService.save(bill);
		return "toList";
	}
	
	public String delete() throws Exception {
		Bill bill = billService.findById(model.getId());
		billService.delete(bill);
		return "toList";
	}
	
	public String editUI() throws Exception {
		List<DormInfo> buildingList = billService.findDormBuilding();
		DormInfo dorm;
		List<DormInfo> dormInfoList = new ArrayList<DormInfo>();
		for (int i=0;i<buildingList.size();i++) {
			dorm = new DormInfo();
			dorm.setName(buildingList.get(i) + "");
			dormInfoList.add(dorm);
		}
		ActionContext.getContext().put("dormInfoList", dormInfoList);
		
		Bill bill = billService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(bill);
		return "saveUI";
	}
	
	public String edit() throws Exception {
		Bill bill  = billService.findById(model.getId());
		bill.setYearMonth(model.getYearMonth());
		
		// 通过计算算出来shouldPay
		double shouldPay = MyConstants.waterPrice * model.getWater() + 
							MyConstants.electricityPrice * model.getElectricity();
		
		bill.setShouldPay(shouldPay);
		//bill.setAlreadyPay(model.getAlreadyPay());
		bill.setWater(model.getWater());
		bill.setElectricity(model.getElectricity());
		bill.setWaterPrice(model.getWaterPrice());
		bill.setElectricityPrice(model.getElectricityPrice());
		billService.update(bill);
		return "toList";
	}
	
	public String list() throws Exception {
		List<Bill> billList = billService.findAll();
		ActionContext.getContext().put("billList", billList);
		return "list";
	}
	
	public String room() throws Exception {
		dormName = new String(dormName.getBytes("iso-8859-1"),"UTF-8");
		System.out.println("dormName------>" + dormName);
		List<DormInfo> dormInfoList = billService.findByName(dormName);
		ActionContext.getContext().put("dormInfoList",dormInfoList);
		return "room";
	}

	// -----------------------------------------------------
	public String getDormName() {
		return dormName;
	}

	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	public int getDormId() {
		return dormId;
	}

	public void setDormId(int dormId) {
		this.dormId = dormId;
	}

}
