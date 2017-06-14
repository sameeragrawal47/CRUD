
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
           Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_record", "root", "");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Stud e){  
        int status=0;  
        try{  
            Connection con=StudDao.getConnection(); 
            PreparedStatement ps=con.prepareStatement(  
                         "insert into `student_record`.`student_info`(stud_id,stud_firstname,stud_lastname,stud_age,stud_course_id) values (NULL,?,?,?,?)");
            
            ps.setString(1,e.getFirstname());  
            ps.setString(2,e.getLastname());  
            ps.setString(3,e.getAge());  
            ps.setString(4,e.getCourse());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Stud e){  
        int status=0;  
        try{  
            Connection con=StudDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update student_info set stud_firstname=?,stud_lastname=?,stud_age=?,stud_course_id=? where stud_id=?");  
            ps.setString(1,e.getFirstname());  
            ps.setString(2,e.getLastname());  
            ps.setString(3,e.getAge());  
            ps.setString(4,e.getCourse());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=StudDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from student_info where stud_id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Stud getEmployeeById(int id){  
        Stud e=new Stud();  
        int course=0;
          
        try{  
            Connection con=StudDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from student_info where stud_id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setFirstname(rs.getString(2));  
                e.setLastname(rs.getString(3));  
                e.setAge(rs.getString(4));
                course=rs.getInt(5);
//                e.setCourse(rs.getInt(5)); 

            }  
            PreparedStatement ps1=con.prepareStatement("select * from stud_course where course_id=?");
            ps1.setInt(1,course);
            ResultSet rs1=ps1.executeQuery();
            while(rs1.next())
            {
                e.setCourse(rs1.getString("student_course"));
            }
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Stud> getAllEmployees(){  
        List<Stud> list=new ArrayList<Stud>();  
          
        try{  
            Connection con=StudDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from student_info");  
            ResultSet rs=ps.executeQuery();
              
            int course=0;
            while(rs.next()){  
                Stud e=new Stud();
                e.setId(rs.getInt(1));  
                e.setFirstname(rs.getString(2));  
                e.setLastname(rs.getString(3));  
                e.setAge(rs.getString(4));  
                course=rs.getInt(5);
//                e.setCourse(rs.getString(5));  
               
            PreparedStatement ps1=con.prepareStatement("select * from stud_course where course_id=?");
            ps1.setInt(1,course);
            ResultSet rs1=ps1.executeQuery();
            if(rs1.next())
            {
                e.setCourse(rs1.getString("student_course"));
            }
             list.add(e);  
            } 
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  