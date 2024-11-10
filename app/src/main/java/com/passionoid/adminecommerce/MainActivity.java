package com.passionoid.adminecommerce;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private EditText editText, etd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et);
        etd = findViewById(R.id.etd);
        Button button = findViewById(R.id.btn);

        button.setOnClickListener(view -> {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("posts").push();
            Map<String, Object> map = new HashMap<>();
            map.put("id", databaseReference.getKey());
            map.put("title", editText.getText().toString());
            map.put("desc", etd.getText().toString());
            databaseReference.setValue(map);
        });
    }
}
