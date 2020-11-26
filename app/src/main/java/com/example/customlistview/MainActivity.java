package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {
    protected ListView myListViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListViewPerso = findViewById(R.id.listviewperso);

        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
        HashMap<String, String> map;
        map = new HashMap<>();
        map.put("titre", "word");
        map.put("description", "Editeur de texte");
        map.put("img", String.valueOf(R.mipmap.word));
        listItem.add(map);
        map = new HashMap<>();
        map.put("titre", "excel");
        map.put("description", "Editeur de texte");
        map.put("img", String.valueOf(R.mipmap.excel));
        listItem.add(map);
        listItem.add(map);
        map = new HashMap<>();
        map.put("titre", "powerpoint");
        map.put("description", "Editeur de texte");
        map.put("img", String.valueOf(R.mipmap.powerpoint));
        listItem.add(map);
        listItem.add(map);
        map = new HashMap<>();
        map.put("titre", "outlook");
        map.put("description", "Editeur de texte");
        map.put("img", String.valueOf(R.mipmap.outlook));
        listItem.add(map);
        SimpleAdapter adapter = new SimpleAdapter(this.getApplicationContext(),
                listItem,
                R.layout.activity_list_item,
                new String[]{"img", "titre", "description"},
                new int[]{R.id.img, R.id.titre, R.id.description});
        myListViewPerso.setAdapter(adapter);
        myListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap map1 = (HashMap) myListViewPerso.getItemAtPosition(position);
                String titre = (String) map1.get("titre");
                Toast.makeText(MainActivity.this, titre, Toast.LENGTH_SHORT).show();

            }
        });


    }
}