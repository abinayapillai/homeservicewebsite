<%@page import="dao.WorkDaoImp"%>
<%@page import="dao.UserDaoImp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Work"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
body {
height:100%;
   width:100%;
   background-image:url(two.jpg);/*your background image*/  
   background-repeat:no-repeat;/*we want to have one single image not a repeated one*/  
   background-size:cover;/*this sets the image to fullscreen covering the whole screen*/  
   /*css hack for ie*/     
   filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='.two.jpg',sizingMethod='scale');
   -ms-filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(src='two-.jpg',sizingMethod='scale')";
  color: white;
}

h1 {
  color: white;
}
</style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Home Service Website  </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="Home.jsp">Home</a></li>
      <li><a href="Home.jsp">LogOut</a></li>
    </ul>
  </div>
</nav>
<%
	//String time= request.getParameter("time");
	int id = Integer.parseInt( request.getParameter("id") );
	Work work = new Work();
	work = new WorkDaoImp().getWorkById(id);
	String time = work.getAvailabelTimings();
	String servicename = work.getServiceName();
	
	List<User> UserList = new ArrayList<>();
	UserList = new UserDaoImp().getAllUser();
	String worker="Not Available";
	for( User temp: UserList) {
		
	   if(temp.getSkill().equals(servicename) && temp.getStatus().equals("Not Assigned") )
	   {
		  worker = temp.getFirstName(); 
	      break;
	   }
	}
    

%>
<h2><center>Request Allotment</center></h2>
<table class="table">
<form action="RequestController" method="post">
<tr><td><center><br/> Worker: <font color="black"><input type="text" name="tf1" value="<%=worker%>"  readonly="readonly"/></font></center></td></tr>
<tr><td><center><br/> Time: <font color="black"><input type="text" name="tf2" value="<%=time %>"  readonly="readonly"/></font></center></td></tr>
<tr><td><center><br/> Address:<font color="black"><input type="text" name="tf3" required/></font></center></td></tr>
<tr><td><center><br/> <input  type="submit" value="SUBMIT"class="btn btn-info"/></center></td></tr>
</form>
<br/>
<hr/>
</body>
</html>