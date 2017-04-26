package services;


import java.sql.SQLException;

import repositories.IConnection;

import java.sql.*;

public class JdbcConnection implements IConnection{
	

    private String connectionString="jdbc:mysql://localhost:3306/db_sys_group_5";
    private String sqlUser="root";
    private String sqlPass="liverpool";

    @Override
    public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(connectionString, sqlUser, sqlPass);
        }
        catch(ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

        return null;
}
}
