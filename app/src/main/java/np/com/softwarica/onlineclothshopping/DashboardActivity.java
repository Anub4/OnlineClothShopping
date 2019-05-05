package np.com.softwarica.onlineclothshopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import adapters.RecyclerViewAdapter;
import models.Item;

public class DashboardActivity extends AppCompatActivity {

    Button btnAdd;
    RecyclerView recyclerView;
    List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().setTitle("Dashboard");

        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();
        readFromFile();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, itemList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, AddItemActivity.class));
            }
        });
    }

    private void readFromFile() {
        try {
            FileInputStream fileInputStream = openFileInput("items.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("->");
                Item item = new Item();
                item.setName(parts[0]);
                item.setPrice(Integer.parseInt(parts[1]));
                item.setDesc(parts[2]);
                item.setImgName(parts[3]);
                Toast.makeText(this, parts[0], Toast.LENGTH_SHORT).show();
                itemList.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
