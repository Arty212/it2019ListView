package com.example.it2019listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            users.add(new User("COVID - " + i,
                    "8 800 555 35" + i % 100,
                    R.drawable.virus));

        UserAdapter adapter = new UserAdapter(users);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onClick(User user, int position, View view) {
                Snackbar.make(list, user.name, Snackbar.LENGTH_LONG).show();
            }
        });

    }
}
