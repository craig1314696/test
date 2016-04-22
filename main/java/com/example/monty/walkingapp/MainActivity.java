package com.example.monty.walkingapp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView walk_location;
    String db_username = "user_db_1314696_walkingDB";
    String db_password = "P@55word";
    String db_connection = "jdbc:jtds:sqlserver://SQL2014.studentwebserver.co.uk";
    Statement stmt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateWalksList();



        walk_location = (ListView) findViewById(R.id.info);
        connectToDb();
    }

    public void getName() {
        String sql;
        sql = "SELECT * FROM Walks";
        try {
            ResultSet rst = stmt.executeQuery(sql);
            while (rst.next()) {
                System.out.print(rst.getString("walk_name"));
            }
        } catch (Exception e) {
            //wLength.setText("connection error " + e.getMessage());
        }
    }



    public void connectToDb() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            Connection DbConn = DriverManager.getConnection(db_connection, db_username, db_password);

            stmt = DbConn.createStatement();
        } catch (Exception e) {
        }
    }

    public void populateWalksList() {
        ArrayList<Walks> walks = Walks.getWalks();
        // Create the adapter to convert the array to views
        CustomWalkAdapter adapter = new CustomWalkAdapter(this, walks);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvWalks);
        listView.setAdapter(adapter);
    }
}


