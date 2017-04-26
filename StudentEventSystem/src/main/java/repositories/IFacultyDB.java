package repositories;

import java.sql.Connection;
import java.util.ArrayList;

import group05.database.models.Faculty;

public interface IFacultyDB {
	ArrayList<Faculty> getAllFaculty(Connection connection);
}
