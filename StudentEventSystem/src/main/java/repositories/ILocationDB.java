package repositories;

import java.sql.Connection;
import java.util.ArrayList;
import group05.database.models.Location;

public interface ILocationDB {
	void create(Connection con,Location location);
	void delete(Connection con,Location location);
	void update(Connection con,Location location);
	Location getLocation(Connection con,Location location);
	ArrayList<Location> getAllLocation(Connection con);

}
