
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Student</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Stud e=StudDao.getEmployeeById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>First Name:</td><td><input type='text' name='fname' value='"+e.getFirstname()+"'/></td></tr>"); 
        out.print("<tr><td>Last Name:</td><td><input type='text' name='lname' value='"+e.getLastname()+"'/></td></tr>"); 
        
        out.print("<tr><td>Age:</td><td><input type='text' name='age' value='"+e.getAge()+"'/></td></tr>");  
        out.print("<tr><td>Course:</td><td><input type='text' name='course' value='"+e.getCourse()+"'/></td></tr>");
         
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Update'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  