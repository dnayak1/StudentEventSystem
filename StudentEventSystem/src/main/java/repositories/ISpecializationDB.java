package repositories;



import java.sql.Connection;
import java.util.ArrayList;

import group05.database.models.Specialization;

public interface ISpecializationDB {
	ArrayList<Specialization> getAllSpecialization(Connection con);
}
