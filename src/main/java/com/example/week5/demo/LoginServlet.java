package com.example.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username6=getServletConfig().getServletContext().getInitParameter("username");
        String password6=getServletConfig().getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username6,password6);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head><title>Login</title></head>");
        out.println("<body>");
        String sql2="select * from usertable where username=? and password=?";
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement(sql2);
            ps.setString(1,username);
            ps.setString(2,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        String sql2="select * from usertable";
        ResultSet rs= null;
        try {
            String username1=null;
            String password1=null;
            rs = ps.executeQuery();
            while(rs.next()){
                username1=rs.getString("username");
                password1=rs.getString("password");
                }
            if(username.equals(username1) && password1.equals(password))
            {
                out.println("<b>"+"Login Success!!!"+"<br><br>");
                out.println("<b>"+"Welcome,"+"<b>" + "<b>"+username+"<b>");
            }
            else{
                out.println("Error");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
