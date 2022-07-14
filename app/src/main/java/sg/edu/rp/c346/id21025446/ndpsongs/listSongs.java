package sg.edu.rp.c346.id21025446.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class listSongs extends AppCompatActivity {
    Button btnlv;
    ListView lvSongs;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);

        btnlv = findViewById(R.id.btnlv);
        lvSongs = findViewById(R.id.lvSongs);

        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
        lvSongs.setAdapter(aa);

        DBHelper dbh = new DBHelper(listSongs.this);
        al.addAll(dbh.getAllSongs());

        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Song data = al.get(i);
                Intent intent = new Intent(listSongs.this, editSongs.class);
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });

        btnlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(listSongs.this);
        al.clear();
        al.addAll(dbh.getAllSongs());
        aa.notifyDataSetChanged();
    }
}