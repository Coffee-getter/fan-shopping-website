<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="/struts-tags" prefix="s" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>爱尚网扇品</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>
	
		<div id="page">
			<div id="header">
				<jsp:include page="header.jsp" />      
       		</div>
			
			<div id="left_column">
				<jsp:include page="left_column.jsp" />  
			</div>
			
			<div id="center_column">	
			
						
				<div id=item_img>
					<img width="300px" height="225px" src="<s:property value="#request.item.img"/>" />
				</div>
				<div id=item_other>
					<form action="cart_view.jsp" method="post">
						品&nbsp;&nbsp;&nbsp;&nbsp;名：&nbsp;<span  style="font-size:15px;font-weight:bold;"><s:property value="#request.item.name"/></span><br>
						原&nbsp;&nbsp;&nbsp;&nbsp;价：&nbsp;<span  style="text-decoration: line-through;"><s:property value="#request.item.oneprice"/>元</span><br>
						促&nbsp;&nbsp;&nbsp;&nbsp;销：&nbsp;<span  style="font-size:28px;font-weight:bold;color:#B22222;"><s:property value="#request.item.price"/></span>元<br>
						售&nbsp;&nbsp;&nbsp;&nbsp;出：&nbsp;<span  style="font-weight:bold;color:#CC6600;"><s:property value="#request.item.sale"/></span>件<br>
						数&nbsp;&nbsp;&nbsp;&nbsp;量：&nbsp;<input type="text" name="quantity" size="6" style="color:#66668C;" value="1">件<p>
						<img src="images/buy_button.png" />&nbsp;&nbsp;
					
						<input type="hidden" name="id" value="<s:property value="#request.item.id"/>">
						<input type="hidden" name="name" value="<s:property value="#request.item.name"/>">
						<input type="hidden" name="price" value="<s:property value="#request.item.price"/>">
						<input type="image" src="images/shopping_button.png" name="submit" value="加入购物车"></p>
					</form>
				</div>
				
				
				
				<div id=item_details><img src="images/details.gif" /></div>
				<div id="item_parameter">
					<div style="float: left;width:230px;color:#404040;">&nbsp;&nbsp;&nbsp;货号：<s:property value="#request.item.id"/></div><div style="float: left;width:230px;color:#404040;">类别：<s:property value="#request.item.sort"/></div><div style="float: left;width:230px;color:#404040;">扇面材质:<s:property value="#request.item.face"/></div><br>
					<div style="float: left;width:230px;color:#404040;">&nbsp;&nbsp;&nbsp;扇骨材质：<s:property value="#request.item.body"/></div><div style="float: left;width:230px;color:#404040;">扇骨数量：<s:property value="#request.item.quantity"/>根</div><div style="float: left;width:230px;color:#404040;">扇骨长度：<s:property value="#request.item.length"/>CM</div>
				</div>
				<div id="item_show_img">
					<img src="<s:property value="#request.item.source"/>" />
				</div>
			</div>
			
			<div id="footer">
				<jsp:include page="bottom.jsp" />  
			</div>
		</div>
	
</body>
</html>