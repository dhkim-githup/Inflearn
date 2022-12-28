<%@ page import="com.example.webstory.vo.People" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.webstory.comm.DbConn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%
	DbConn dbConn = new DbConn();
	List<People> list = (List<People>) request.getAttribute("list");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select </title>
</head>
<body>


<h1>  HTML -> Servlet -> Jsp -> MVC </h1>

 <a href="/4.MVC_Start/index.html">● Home </a>
 <p>

 <table style="width: 600px;" border="0">
		<tr style="height: 40px">
			<td align="center">ID</td>
			<td align="center">이름</td>
			<td align="center">나이</td>
			<td align="center">등록일자</td>
			<td> 삭제 </td>
		</tr>

	<%
			String strId;

	try{
			for(People p : list){
				strId = p.getStrID();
			%>
				<tr style="height: 40px">
				<td align="center"><%=strId%></td>
				<td align="center"><%=p.getStrName()%></td>
				<td align="center"><%=p.getStrAge()%></td>
				<td align="center"><%=p.getStrDati()%></td>
				<td><a href="/4.MVC_Start/DeletePeople?id=<%=strId%>">삭제 </a></td>
			</tr>
			<%
			}

	  }catch (Exception e) {
			System.out.println("Error =>"+e);
		 }finally {
		}

	%>


	</table>

</body>
</html>