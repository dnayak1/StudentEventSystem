package group05.database.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import repositories.IConnection;
import services.FacultyDB;
import services.JdbcConnection;
@Controller
public class FacultyController {
	IConnection connection;
	FacultyDB facultyDB;
	@RequestMapping(value="/faculty",method=RequestMethod.GET)
	public String Faculties(Model model){
		connection=new JdbcConnection();
		facultyDB=new FacultyDB();
		model.addAttribute("faculty",facultyDB.getAllFaculty(connection.getConnection()));
		return"Faculty";
	}
}
