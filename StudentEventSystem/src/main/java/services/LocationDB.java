package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import group05.database.*;
import group05.database.models.Location;
import repositories.ILocationDB;

public class LocationDB implements ILocationDB {
	private String query;
	@Override
	public void create(Connection con,Location location) {
		query="insert into"+Constants.Location.LOCATION_TABLE+"("+Constants.Location.LOCATION_ID
				+","+Constants.Location.LOCATION_NAME +") values(null,?)";
		PreparedStatement stmt;
		try {
			stmt=con.prepareStatement(query);
			stmt.setString(0, location.getLocationName());
			stmt.executeUpdate();    
			con.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
	}

	@Override
	public void delete(Connection con,Location location) {
		query="delete from location where"+ Constants.Location.LOCATION_ID+"=?"; 
		PreparedStatement stmt=null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setLong(0, location.getLocationId());
			stmt.executeUpdate();
			con.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

	@Override
	public void update(Connection con,Location location) {
		query="update table "+Constants.Location.LOCATION_TABLE+" set "+Constants.Location.LOCATION_NAME
				+" = ? where "+Constants.Location.LOCATION_ID+" = ?";
		PreparedStatement stmt=null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(0, location.getLocationName());
			stmt.setLong(1, location.getLocationId());
			stmt.executeUpdate();
			con.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

	@Override
	public Location getLocation(Connection con,Location location) {
		Location locationOutput=new Location();
		query="select * from "+Constants.Location.LOCATION_TABLE+" where "+Constants.Location.LOCATION_ID
				+ "=?";
		PreparedStatement stmt=null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(0, location.getLocationName());
			stmt.setLong(1, location.getLocationId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                locationOutput.setLocationName(rs.getString("LocationName"));
                }
			con.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return locationOutput;
	}

	@Override
	public ArrayList<Location> getAllLocation(Connection con) {
		query="select * from "+Constants.Location.LOCATION_TABLE;
		PreparedStatement stmt=null;
		ArrayList<Location> allLocationOutput=new ArrayList<>();
		try {
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Location locationOutput=new Location();
				locationOutput.setLocationName(rs.getString("LocationName"));
                allLocationOutput.add(locationOutput);
                }
			con.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return allLocationOutput;
	}
	
	
	
	

}
