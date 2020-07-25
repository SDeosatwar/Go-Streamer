package com.example.gostreamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ott extends AppCompatActivity {
EditText txtname, no_movies, no_tv;
Button btn_save;
DatabaseReference ref;
add_OTT add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ott);
        txtname=(EditText)findViewById(R.id.et1);
        no_movies=(EditText)findViewById(R.id.et3);
        no_tv=(EditText)findViewById(R.id.et4);
        btn_save=(Button)findViewById(R.id.button1);
        add=new add_OTT();
        ref= FirebaseDatabase.getInstance().getReference().child("OTT");
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int movies=Integer.parseInt(no_movies.getText().toString().trim());
                int tv=Integer.parseInt(no_tv.getText().toString().trim());
                add.setName(txtname.getText().toString().trim());
                add.setMovies(movies);
                add.setTv(tv);
                ref.push().setValue(add);
                Toast.makeText(ott.this,"successfully added",Toast.LENGTH_LONG).show();
            }
        });
    }
}