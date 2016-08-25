package ff2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

public class Dbconn extends HttpServlet
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	//PreparedStatement  ps;
	public void init()
	{
		String driver=getServletConfig().getServletContext().getInitParameter("driver");
		String url=getServletConfig().getServletContext().getInitParameter("url");
		String user=getServletConfig().getServletContext().getInitParameter("user");
		String pass=getServletConfig().getServletContext().getInitParameter("pass");
		
		//System.out.println("Display:"+driver+url);
		
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
			stmt=con.createStatement();
			rs=stmt.executeQuery("Select * from logintb");
			while(rs.next())
			
				System.out.println("User Name:"+rs.getString(1)+   " Password is:"+rs.getInt(2));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
