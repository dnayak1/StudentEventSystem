package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import group05.database.Constants;
import group05.database.models.Faculty;
import repositories.IFacultyDB;

public class FacultyDB implements IFacultyDB{
	private String query;
	@Override
	public ArrayList<Faculty> getAllFaculty(Connection connection) {
		query="select "+"p."+Constants.Persons.PERSON_NAME+","+"f."+Constants.Faculty.POSITION_TITLE
				+","+"f."+Constants.Faculty.HIGHEST_DEGREE+","+"d."+Constants.Department.DEPARTMENT_NAME
				+","+"p."+Constants.Persons.MAIL_ID+" from "+Constants.Faculty.FACULTY_TABLE +" f "
				+"join "+Constants.Persons.PERSON_TABLE+" p "+"on "+"f."+Constants.Persons.PERSON_ID+"="
				+"p."+Constants.Persons.PERSON_ID+" join "+ Constants.Department.DEPARTMENT_TABLE
				+" d "+"on "+"f."+Constants.Department.DEPARTMENT_ID+"="+"d."
				+Constants.Department.DEPARTMENT_ID;
		PreparedStatement stmt=null;
		ArrayList<Faculty> allFacultyOutput=new ArrayList<>();
		try {
			stmt=connection.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				Faculty facultyOutput=new Faculty();
				facultyOutput.setDepartmentName(rs.getString(Constants.Department.DEPARTMENT_NAME));
				facultyOutput.setHighestDegree(rs.getString(Constants.Faculty.HIGHEST_DEGREE));
				facultyOutput.setMailId(rs.getString(Constants.Persons.MAIL_ID));
				facultyOutput.setPersonName(rs.getString(Constants.Persons.PERSON_NAME));
				facultyOutput.setPositionTitle(rs.getString(Constants.Faculty.POSITION_TITLE));
				allFacultyOutput.add(facultyOutput);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allFacultyOutput;
	}

}
