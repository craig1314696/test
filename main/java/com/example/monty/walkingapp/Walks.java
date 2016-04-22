package com.example.monty.walkingapp;

import android.widget.ListView;
import android.widget.TextView;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Walks {
    public static String walk_name;
    public static String walk_location;
    public static String walk_difficulty;
    public int walk_distance;
    public int walk_length;
    public static Statement stmt;


    public Walks(String name, String location, String difficulty, int distance, int length) {
        String sql;
        sql = "SELECT * FROM Walks";
        try {
            ResultSet rst = stmt.executeQuery(sql);
            while (rst.next()){
                walk_name = rst.getString("walk_name");
                walk_location = rst.getString("walk_location");
                walk_difficulty = rst.getString("walk-difficulty");
                //num4 = rst.getString(4);
                //num5 = rst.getString(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static ArrayList<Walks> getWalks(){
        ArrayList<Walks> walks = new ArrayList<>();
                walks.add(new Walks(walk_name,walk_location,walk_difficulty,1,1));
        return walks;
    }



}