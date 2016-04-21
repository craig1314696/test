package com.example.monty.walkingapp;

import android.widget.ListView;
import android.widget.TextView;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Walks {
    public String walk_name;
    public String walk_location;
    public String walk_difficulty;
    public int walk_distance;
    public int walk_length;
    public static Statement stmt;


    public Walks(String name, String location, String difficulty, int distance, int length) {
        this.walk_name = name;
        this.walk_location = location;
        this.walk_difficulty = difficulty;
        this.walk_distance = distance;
        this.walk_length = length;
    }



    public static ArrayList<Walks> getWalks() {
        ArrayList<Walks> walks = new ArrayList<>();
        String sql;


        sql = "SELECT * FROM Walks";
        try {
            ResultSet rst = stmt.executeQuery(sql);
            walks.add(new Walks(rst.getString("walk_name"), rst.getString("walk_location"), rst.getString("walk_difficulty"),1,1));
            for(ResultSet i = (ResultSet) walks.iterator(); i.next(); ) {
                walks.add(rst);
                //walks.add(new Walks(rst.getString("walk_name"), rst.getString("walk_location"), rst.getString("walk_difficulty"),1,1));
                //String item = i.next();
                //System.out.println(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        walks.add(new Walks("yy44","wfwfwfw","dwegweg", 1,2));
        return walks;
    }




}