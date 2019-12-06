package sample.database;

import sample.controller.AddItemController;
import sample.models.Task;
import sample.models.User;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.concurrent.CompletionService;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    public  Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://"
                + dbHost + ":"
                + dbPort + "/"
                + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(User user) {

        String insert = "INSERT INTO "+Const.USERS_TABLE+"("+Const.USERS_FIRSTNAME
                +","+Const.USERS_LASTNAME+","+Const.USERS_USERNAME+","
                +Const.USERS_PASSWORD+","+Const.USERS_GENDER+")"
                +"VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getGender());

            preparedStatement.executeUpdate();
            dbConnection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user){
        ResultSet resultSet = null;
        if (!user.getUserName().equals("") || !user.getLastName().equals("")) {
            //select all from users table where username="username" and password ="password"
            String query = "SELECT * FROM "
                    + Const.USERS_TABLE
                    + " WHERE "
                    + Const.USERS_USERNAME
                    + "=?" + " AND "
                    + Const.USERS_PASSWORD
                    + "=?";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassword());

                resultSet = preparedStatement.executeQuery();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else {

        }

        return resultSet;
    }

    public void insertTask(Task task){
        String query = "INSERT INTO "+Const.TASKS_TABLE+"("+Const.TASKS_USERID+","+Const.TASKS_DATECREATED
                +","+Const.TASKS_DESCRIPTION+","+Const.TASKS_TASK+")"
                +"VALUES(?,?,?,?)";

        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);

            preparedStatement.setInt(1, task.getUserId());
            preparedStatement.setTimestamp(2, task.getDateCreated());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setString(4, task.getTask());

            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        /*String insert = "INSERT INTO "+Const.TASKS_TABLE+"(" +Const.TASKS_DATECREATED +","+Const.TASKS_DESCRIPTION+","
                +Const.TASKS_TASK+")"
                +"VALUES(?,?,?)";*/
/*
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

//            preparedStatement.setInt(1, AddItemController.userId);
            preparedStatement.setTimestamp(1, task.getDateCreated());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, task.getTask());

            preparedStatement.executeUpdate();
            dbConnection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }
}
