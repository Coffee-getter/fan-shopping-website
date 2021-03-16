package com.actions;

import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.beans.Userinfo;
import com.db.DataProcess;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	private String userName;
	private String pwd;
	private String pwd1;
	private String sex;
	private String interest[];

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getPwd1() {
		return pwd1;
	}


	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String[] getInterest() {
		return interest;
	}


	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	
	public String login() {
		String username = this.userName;
		String password = this.pwd;
		
		// ��֤����:����֤����ָ�룬���ַ�����
		if(username==null||username.equals("")||password.equals("")||password==null){
			ActionContext.getContext().put("mess", "input data!");
			return "loginError";
		}
		// ��������:�������ݿ���֤��¼�Ƿ�ɹ�
		// ��¼sql������DataProcess��getData(string)����
		String sql = "SELECT * FROM webshopping.userinfo where username = '"+username+"' and password = '"+password+"'";
		DataProcess data = new DataProcess();
		Vector rows = data.getData(sql);
		if(rows.size()==0) {
			ActionContext.getContext().put("mess", "username or password error!");
			return "loginError";
		}
		// ����¼�ɹ������û���Ϣ����session,��ת��index.jsp
		Userinfo userinfo = new Userinfo();
		userinfo.setUsername(username);
		
		ActionContext.getContext().getSession().put("userinfo",userinfo);
		return "loginSuccess";
	}
	
	
	public String reg() {
		String username = this.userName;
		String password1 = this.pwd;
		String password2 = this.pwd1;
		String sex = this.sex;
		String[] hobby = this.interest;
		//��֤����
		if(username==null||username.equals("")){
			//response.sendRedirect("reg.jsp");
			ActionContext.getContext().put("mess", "input data plese!");
			return "regError";
		}
		if(password1.equals(password2)==false){
			//response.sendRedirect("reg.jsp");
			ActionContext.getContext().put("mess", "password is wrong!");
			return "regError";
		}
		//��������
		String s_hobby = "";
		if(hobby!=null){
			for(int i=0;i<hobby.length;i++){
				if(i!=0)s_hobby+="��";
				s_hobby+=hobby[i];
			}
		}	
		// ע��sql,����DataProcess��update(string)����
		String sql = "INSERT INTO userinfo (username, password, sex, hobby) VALUES ('"+username+"', '"+password1+"', '"+sex+"', '"+s_hobby+"');";
		DataProcess data = new DataProcess();
		int re = data.update(sql);
		if(re==-1) {
			ActionContext.getContext().put("mess", "Registration failed!!");
			return "regError";
		}
		// ����¼�ɹ������û���Ϣ����request,��ת��showReg.jsp
		Userinfo userinfo = new Userinfo();
		userinfo.setUsername(username);
		userinfo.setPassword(password1);
		userinfo.setSex(sex);
		userinfo.setHobby(s_hobby);

		ActionContext.getContext().put("userinfo", userinfo);
		return "regSuccess";
	}
	
	
	public String logout() {
		ActionContext.getContext().getSession().clear();;
		return "logoutSuccess";
	}
	
}
