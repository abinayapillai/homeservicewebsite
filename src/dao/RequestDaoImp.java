package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Driver;


import model.Admin;
import model.DB;
import model.Request;
import model.User;

public class RequestDaoImp implements RequestDao
{

	@Override
	public void addRequest(Request request) {
		// TODO Auto-generated method stub
		try {
			Connection con = DB.getConnection();
			String sql = "insert into requests(Worker_Alloted,Time,Address) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
		    ps.setString(1,request.getWorker() );
			ps.setString(2, request.getTime() );
			ps.setString(3, request.getAddress() );
			int rowaffected = 	ps.executeUpdate();
			System.out.println(rowaffected + " rows inserted");		
			con.close();
			 }catch(Exception e){
				 System.out.println("Error : " + e);
			 }
			
	}

	@Override
	public Request getRequestById(int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllRequest() {
		// TODO Auto-generated method stub
		List<Request> RequestList = new ArrayList<>();
		try {
			
			Connection con = DB.getConnection();
			String sql ="select * from requests";
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				Request f = new Request(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				RequestList.add(f);
			}
			
		}catch(Exception e) {
			System.out.println("Error UserDao getallusers() : "+ e);
		}
		return RequestList;
	}

	@Override
	public void updateRequest(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteRequest(int requestId) {
		// TODO Auto-generated method stub
		
	}

	
 
}

