package com.example.booking;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("\book")
public class BookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String movie = req.getParameter("movie");
        int seats = Integer.parseInt(req.getParameter("seats"));

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bookingdb",
                    "root",
                    "root"
            );

            String insert = "INSERT INTO tickets(name,movie,seats) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,movie);
            preparedStatement.setInt(3,seats);
            preparedStatement.execute();
            connection.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
