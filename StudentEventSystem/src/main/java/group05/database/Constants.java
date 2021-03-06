package group05.database;

public class Constants {
	public static class Location{
		public static final String LOCATION_NAME="locationName";
		public static final String LOCATION_ID="locationId";
		public static final String LOCATION_TABLE="location";
	}
	public static class Specialization{
		public static final String SPECIALIZATION_TABLE="specialization";
		public static final String SPECIALIZATION_NAME="SName";	
		public static final String SPECIALIZATION_CODE="SCode";	
	}
	public static class Department{
		public static final String DEPARTMENT_TABLE="department";
		public static final String DEPARTMENT_NAME="DepartmentName";
		public static final String DEPARTMENT_ID="DepartmentId";
	}
	public static class Faculty{
		public static final String FACULTY_TABLE="faculty";	
		public static final String POSITION_TITLE="PositionTitle";
		public static final String HIGHEST_DEGREE="HighestDegree";
	}
	public static class Persons{
		public static final String PERSON_TABLE="persons";
		public static final String PERSON_ID="PersonId";
		public static final String PERSON_NAME="PersonName";
		public static final String MAIL_ID="MailId";	
	}
	public static class Student{
		public static final String STUDENT_TABLE="student";
		public static final String ON_CAMPUS="OnCampus";
		public static final String GRADUATION_YEAR="GraduationYear";
		public static final String FACULTY_ID="FacultyId";
		public static final String MAJOR_CODE="MajorCode";
		public static final String MINOR_CODE="MinorCode";
	}

}
