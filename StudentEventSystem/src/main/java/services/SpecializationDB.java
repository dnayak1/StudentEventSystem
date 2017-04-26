package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import group05.database.Constants;
import group05.database.models.Specialization;
import repositories.ISpecializationDB;

public class SpecializationDB implements ISpecializationDB {
	private String query;

	@Override
	public ArrayList<Specialization> getAllSpecialization(Connection con) {
		query="select "+ Constants.Department.DEPARTMENT_NAME+","+
				Constants.Specialization.SPECIALIZATION_NAME+" from "+
				Constants.Department.DEPARTMENT_TABLE +" join "+
				Constants.Specialization.SPECIALIZATION_TABLE +" on "+
				Constants.Specialization.SPECIALIZATION_TABLE+"."+
				Constants.Department.DEPARTMENT_ID+"="+
				Constants.Department.DEPARTMENT_TABLE+"."+
				Constants.Department.DEPARTMENT_ID;
		
		//select SName,Departmentname from specialization join department on specialization.DepartmentId=department.DepartmentId
		
		PreparedStatement stmt=null;
		ArrayList<Specialization> allSpecializationOutput=new ArrayList<>();
		try {
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Specialization specializationOutput=new Specialization();
				specializationOutput.setSpecializationName(rs.getString(Constants.Specialization.SPECIALIZATION_NAME));
				specializationOutput.setDeptName(rs.getString(Constants.Department.DEPARTMENT_NAME));
				allSpecializationOutput.add(specializationOutput);
                }
			con.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return allSpecializationOutput;
	}

}
