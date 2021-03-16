package com.actions;

import java.util.Vector;
import java.util.*;
import com.beans.Product;
import com.db.DataProcess;
import com.opensymphony.xwork2.ActionContext;

public class ProductAction {
	private int page;//�ڼ�ҳ
	private int onepage = 6;//һҳ�м���
	private String action;//�û���Ϊ
	
	
	
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

	//��ȡ������Ʒ��Ϣ
	public String productShow() {//�޲Σ����У�����������String
		
		if("next".equals(this.action)) {
			this.page++;
		}else if("back".equals(this.action)) {
			this.page--;
		}
		
		
		
		
		
		
		String sql = "select id,name,price,img,sale from product";
		DataProcess data = new DataProcess();
		Vector rows = data.getData(sql);
		//��ѯ����
		if(rows.size()==0) {//��ȡ������Ʒ��Ϣ
			ActionContext.getContext().put("mess", "Data load failed!");
			return "DataLoadError";
		}
		
		//��ϵ������ת��Ϊ�������ݣ�ORM
		ArrayList<Product> list = new ArrayList<Product>();//��Ŷ������ݼ�
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
		
		//����request���ڵ�ģ��
		ActionContext.getContext().put("products", list);
		ActionContext.getContext().put("page", this.page);
		
		return "showSuccess";
	}
}
