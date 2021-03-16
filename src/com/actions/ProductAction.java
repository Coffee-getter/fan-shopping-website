package com.actions;

import java.util.Vector;
import java.util.*;
import com.beans.Product;
import com.db.DataProcess;
import com.opensymphony.xwork2.ActionContext;

public class ProductAction {
	private int page;//第几页
	private int onepage = 6;//一页有几个
	private String action;//用户行为
	
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	//获取所有商品信息
	public String productShow() {//无参，公有，返回类型是String
		
		if("next".equals(this.action)) {
			this.page++;
		}else if("back".equals(this.action)) {
			this.page--;
		}
		
		
		
		
		
		
		String sql = "select id,name,price,img,sale from product";
		DataProcess data = new DataProcess();
		Vector rows = data.getData(sql);
		//查询错误
		if(rows.size()==0) {//获取所有商品信息
			ActionContext.getContext().put("mess", "Data load failed!");
			return "DataLoadError";
		}
		
		//关系型数据转换为对象数据：ORM
		ArrayList<Product> list = new ArrayList<Product>();//存放对象数据集
		Product product = null; 
		
		
		if(this.page==0) {
			this.page++;
		}else if((this.page-1)*this.onepage>=rows.size()) {
			this.page--;
		}
		
		int down = (this.page-1)*this.onepage;
		int up = (this.page)*this.onepage;
		
		
		for(int i=down;i<up&&i<rows.size();i++) {
//			System.out.println(rows.get(i));
			Vector row = (Vector) rows.get(i);
			product = new Product();
			product.setId(Integer.parseInt((String)row.get(0)));
			product.setName((String)row.get(1));
			product.setPrice(Double.parseDouble((String)row.get(2)));
			product.setImg((String)row.get(3));
			product.setSale(Integer.parseInt((String)row.get(4)));
			list.add(product);
		}
		
		//创建request周期的模型
		ActionContext.getContext().put("products", list);
		ActionContext.getContext().put("page", this.page);
		
		return "showSuccess";
	}
}
