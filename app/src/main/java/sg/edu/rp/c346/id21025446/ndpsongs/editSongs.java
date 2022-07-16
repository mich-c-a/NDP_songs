package sg.edu.rp.c346.id21025446.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class editSongs extends AppCompatActivity {

    EditText etTitle;
    EditText etSinger;
    EditText etYear;
    RadioGroup rgRating;
    Button btnUpdate, btnDelete;
    Song data;
    RadioButton rbSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_songs);
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        rgRating = findViewById(R.id.rgRating);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);


        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText(String.valueOf(data.getYear()));
//        for (int x = 0; x<rgRating.getChildCount(); x++){
//
//            if(Integer.parseInt(rgRating. == data.getStars()){
//                rgRating.check(x);
//                break;
//            }
//        }
    }
}