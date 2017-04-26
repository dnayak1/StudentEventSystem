package group05.database.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import group05.database.models.Location;
import repositories.IConnection;
import repositories.ILocationDB;
import services.JdbcConnection;
import services.LocationDB;

@Controller
public class LocationController {
	IConnection connection;
	Location location;
	ILocationDB locationDB;
	@RequestMapping(value="/location", method=RequestMethod.GET)
	public String Locations(Model model){
		connection=new JdbcConnection();
		locationDB=new LocationDB();
		model.addAttribute("location",locationDB.getAllLocation(connection.getConnection()));
		return "location";
	}
}
