package com.example.gostreamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tv extends AppCompatActivity {
    EditText txtname, ssn, epi, date, rate, ott, genre, lang, age;
    Button btn_save;
    DatabaseReference ref;
    add_tv add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        txtname=(EditText)findViewById(R.id.t1);
        ssn=(EditText)findViewById(R.id.t2);
        epi=(EditText)findViewById(R.id.t3);
        date=(EditText)findViewById(R.id.e4);
        rate=(EditText)findViewById(R.id.e5);
        ott=(EditText)findViewById(R.id.e6);
        genre=(EditText)findViewById(R.id.e7);
        lang=(EditText)findViewById(R.id.e8);
        age=(EditText)findViewById(R.id.e9);
        btn_save=(Button)findViewById(R.id.button);
        add=new add_tv();
        ref= FirebaseDatabase.getInstance().getReference().child("TV");
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int season=Integer.parseInt(ssn.getText().toString().trim());
                int episode=Integer.parseInt(epi.getText().toString().trim());
                int rating=Integer.parseInt(rate.getText().toString().trim());
                int ag=Integer.parseInt(age.getText().toString().trim());
                add.setDate(date.getText().toString().trim());
                add.setName(txtname.getText().toString().trim());
                add.setOtt(ott.getText().toString().trim());
                add.setGenre(genre.getText().toString().trim());
                add.setLang(lang.getText().toString().trim());
                add.setSsn(season);
                add.setEpi(episode);
                add.setRate(rating);
                add.setAge(ag);
                ref.push().setValue(add);
                Toast.makeText(tv.this,"successfully added",Toast.LENGTH_LONG).show();
            }
        });
    }
}
