/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import yumxpress.dbutill.DBConnection;
import yumxpress.pojo.StaffPojo;

/**
 *
 * @author SCALive
 */
public class StaffDAO {
    public static String getNewId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select max(staff_id) from staff");
        rs.next();
        String id = rs.getString(1);
        String staffId = "";
        if (id != null) {
            id = id.substring(4);
            staffId = "STF-" + (Integer.parseInt(id) + 1);
        } else {
            staffId = "STF-101";
        }
        return staffId;

    }
    public static String addStaff(StaffPojo staff)throws SQLException{//return string because we are sending mail
        Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("insert into staff values(?,?,?,?,?)");
       staff.setStaffId(getNewId());
       ps.setString(1, staff.getStaffId());
       ps.setString(2, staff.getCompanyId());
       ps.setString(3,staff.getEmailId());
       ps.setString(4, staff.getPassword());
       ps.setString(5, staff.getStaffName());
       return(ps.executeUpdate()==1?staff.getStaffId():null);
    }
    
     public static List<String> getAllStaffIdByCompanyId(String companyId)throws SQLException{
        Connection conn=DBConnection.getConnection();
         System.out.println(companyId);//////*****
        PreparedStatement ps=conn.prepareStatement("select staff_id from staff where company_id=?");
        ps.setString(1, companyId);
        List<String>staffList=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            staffList.add(rs.getString(1));
        }
        return staffList;
        
    }
    public static StaffPojo getStaffDetailsbyId(String staffId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from staff where staff_id=?");
        ps.setString(1, staffId);
        StaffPojo staff=new StaffPojo();
        ResultSet rs=ps.executeQuery();
        rs.next();
        staff.setStaffName(rs.getString(5));
        staff.setEmailId(rs.getString(3));
        return staff;
        
    }
     public static String getRandomStaffIdFromCompany(String compId)throws SQLException{
        List<String>staffList=StaffDAO.getAllStaffIdByCompanyId(compId);
        Random rand=new Random();
        int index=rand.nextInt(staffList.size());
        return staffList.get(index);
    }
     public static StaffPojo validate(String emailId,String password) throws SQLException{
         Connection conn =DBConnection.getConnection();
         PreparedStatement PS=conn.prepareStatement("select * from staff where email_id=? and password=?");
         PS.setString(1, emailId);
         PS.setString(2, password);
         ResultSet rs=PS.executeQuery();
         StaffPojo staff=null;
         if(rs.next())
         {
             staff=new StaffPojo();
             staff.setStaffId(rs.getString(1));
             staff.setStaffName(rs.getString(2));
             staff.setEmailId(emailId);
         }
         return staff;
     }
}

