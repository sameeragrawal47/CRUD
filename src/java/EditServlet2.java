
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("fname");  
        String password=request.getParameter("lname");  
        String email=request.getParameter("age");  
        String course=request.getParameter("course");  
         int cou_id = Integer.parseInt(course);
          
        Stud e=new Stud();  
        e.setId(id);  
        e.setFirstname(name);  
        e.setLastname(password);  
        e.setAge(email);  
        e.setCourse(course);  
          
        int status=StudDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  