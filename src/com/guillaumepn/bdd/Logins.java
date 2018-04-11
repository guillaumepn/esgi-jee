package com.guillaumepn.bdd;

import com.guillaumepn.beans.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Logins {
    private Connection connection;

    public List<User> listUsers() {
        List<User> users = new ArrayList<>();

        Statement statement = null;
        ResultSet result = null;

        loadDatabase();

        try {
            statement = this.connection.createStatement();

            result = statement.executeQuery("SELECT * FROM users");

            while (result.next()) {
                int id = result.getInt("id");
                String login = result.getString("login");
                String password = result.getString("password");

                User user = new User();
                user.setId(id);
                user.setLogin(login);
                user.setPassword(password);

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endConnection(statement, result);
        }

        return users;
    }

    /**
     * loadDatabase
     */
    private void loadDatabase() {

        try {
            Context env = (Context)new InitialContext().lookup("java:comp/env");
            String dbhost = (String)env.lookup("dbhost");
            String dbport = (String)env.lookup("dbport");
            String dbname = (String)env.lookup("dbname");
            String dblogin = (String)env.lookup("dblogin");
            String dbpassword = (String)env.lookup("dbpassword");

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+ dbhost +":"+ dbport +"/"+ dbname +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", dblogin, dbpassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /**
     * verifUser
     * @param user
     * @return
     */
    public boolean verifUser(User user) {
        boolean foundUser = false;
        Statement statement = null;
        ResultSet result = null;

        loadDatabase();

        try {
            statement = this.connection.createStatement();

            result = statement.executeQuery("SELECT * FROM users WHERE login = '" + user.getLogin() + "' AND password = '" + user.getPassword() + "';");

            while (result.next()) {
                foundUser = true;
            }
        } catch (SQLException e) {
            System.out.println("test");
            e.printStackTrace();
        } finally {
            endConnection(statement, result);
        }

        return foundUser;
    }

    /**
     * endConnection
     * @param statement
     * @param result
     */
    private void endConnection(Statement statement, ResultSet result) {
        try {
            if (result != null) {
                result.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ignore) {
            ignore.printStackTrace();
        }
    }

    /**
     * addUser
     * @param user
     */
    public void addUser(User user) {
        loadDatabase();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (login, password) VALUES(?, ?);");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * deleteUser
     * @param userId
     */
    public void deleteUser(String userId) {
        loadDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?;");
            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
