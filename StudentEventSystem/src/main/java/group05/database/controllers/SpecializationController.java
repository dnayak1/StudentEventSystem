package group05.database.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repositories.IConnection;
import repositories.ISpecializationDB;
import services.JdbcConnection;
import services.SpecializationDB;
@Controller
public class SpecializationController {
	IConnection connection;
	ISpecializationDB specialization;
	SpecializationDB specializationDB;
	@RequestMapping(value="/specialization",method=RequestMethod.GET)
	public String Specializations(Model model){
		connection=new JdbcConnection();
		specializationDB=new SpecializationDB();
		model.addAttribute("specialization",specializationDB.getAllSpecialization(connection.getConnection()));
		return "Specialization";	
	}
}
