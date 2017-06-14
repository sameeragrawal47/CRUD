

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String fname=request.getParameter("fname");  
        String lname=request.getParameter("lname");  
        String age=request.getParameter("age");  
        String course=request.getParameter("course");  
  
          
        Stud e=new Stud();  
        e.setFirstname(fname);  
        e.setLastname(lname);  
        e.setAge(age);  
        e.setCourse(course);  
          
        int status=StudDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  