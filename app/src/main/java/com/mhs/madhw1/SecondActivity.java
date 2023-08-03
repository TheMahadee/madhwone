package com.mhs.madhw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends MainActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList userList = getListData();
        final ListView lv = (ListView) findViewById(R.id.user_list);
        lv.setAdapter(new CustomListAdapter(this, userList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ListRow user = (ListRow) lv.getItemAtPosition(position);
                Toast.makeText(SecondActivity.this, "Selected :" + " " + user.getName()+", "+ user.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();

        if(item.getItemId() == R.id.home) {
            Intent home = new Intent(SecondActivity.this,MainActivity.class);
            startActivity(home);
            return true;
        } else if(item.getItemId() == R.id.list){
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    private ArrayList getListData() {
        ArrayList<ListRow> results = new ArrayList<>();
        ListRow user1 = new ListRow();
        user1.setName("John Doe");
        user1.setDesignation("Manager");
        user1.setId("101");
        results.add(user1);
        ListRow user2 = new ListRow();
        user2.setName("Carl Matthews");
        user2.setDesignation("HR");
        user2.setId("102");
        results.add(user2);
        ListRow user3 = new ListRow();
        user3.setName("Robert Bing");
        user3.setDesignation("Accountant");
        user3.setId("103");
        results.add(user3);
        return results;
    }

}