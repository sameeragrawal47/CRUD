
<%@page import="connection.ConnectionProvider"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>  
<head>  
<meta charset="ISO-8859-1">  
<title>Insert title here</title>  
</head>  
<body>  
  
<h1>Add New Student</h1>  
<form action="SaveServlet" method="post">  
<table>  
<tr><td>First Name:</td><td><input type="text" name="fname"/></td></tr>  
<tr><td>Last Name:</td><td><input type="text" name="lname"/></td></tr>  
<tr><td>Age:</td><td><input type="text" name="age"/></td></tr> 
<tr>
<%
Connection con = null;
   
    PreparedStatement pst = null;
    ResultSet rst = null;
    ConnectionProvider copp = new ConnectionProvider();
    con = copp.ConnectionProvider();
%>
<td>Course:</td>
<td>
    <select name="course" class="form-control">

                            <%                
                        pst = con.prepareStatement("select * from stud_course");
                        rst = pst.executeQuery();
                        if (rst != null) {
                            while (rst.next()) {

                                String stud_course = rst.getString("student_course");
                                String course_id = rst.getString("course_id");


                    %>  

                    <option value="<%=course_id%>"><%=stud_course%></option>
                     <%    }
                        }

                    %>
           </select>
    </select>
</td>
</tr> 


</td></tr>  
<tr><td colspan="2"><input type="submit" value="Save Record"/></td></tr>  
</table>  
</form>  
  
<br/>  
<a href="ViewServlet">view Student Records</a>  
  
</body>  
</html>  
