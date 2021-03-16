package com.actions;

import java.util.ArrayList;
import java.util.Vector;

import com.beans.Item;
import com.beans.Product;
import com.db.DataProcess;
import com.opensymphony.xwork2.ActionContext;

public class ItemAction {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String itemShow() {
		String sql = "select img,name,oneprice,price,sale,sort,face,body,quantity,length,source from product where id = '"+this.id+"'";
		DataProcess data = new DataProcess();
		Vector rows = data.getData(sql);
		//查询错误
		System.out.println(rows.get(0));
		if(rows.size()==0) {//获取所有商品信息
			ActionContext.getContext().put("mess", "Data load failed!");
			return "DataLoadError";
		}
//		
//		//关系型数据转换为对象数据：ORM
		Item item = new Item();
		Vector row = (Vector) rows.get(0);
		item.setId(this.id);
		item.setImg((String)row.get(0));
		item.setName((String)row.get(1));
		item.setOneprice(Double.parseDouble((String)row.get(2)));
		item.setPrice(Double.parseDouble((String)row.get(3)));
		item.setSale(Integer.parseInt((String)row.get(4)));
		item.setSort(Integer.parseInt((String)row.get(5)));
		item.setFace((String)row.get(6));
		item.setBody((String)row.get(7));
		item.setQuantity(Integer.parseInt((String)row.get(8)));
		item.setLength(Integer.parseInt((String)row.get(9)));
		item.setSource((String)row.get(10));
		
		ActionContext.getContext().put("item", item);
		
		return "showSuccess";
	}
	
	
}
