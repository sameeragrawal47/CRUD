import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.jsp'>Add New Student</a>");  
        out.println("<h1>Student List</h1>");  
          
        List<Stud> list=StudDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Age</th><th>Course</th><th>Update</th><th>Delete</th></tr>");  
        for(Stud e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getFirstname()+"</td><td>"+e.getLastname()+"</td><td>"+e.getAge()+"</td><td>"+e.getCourse()+"</td><td><a href='EditServlet?id="+e.getId()+"'>Update</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>Delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  