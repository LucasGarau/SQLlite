package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView aaa;
    private Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aaa = findViewById(R.id.aaaa);
        Base(aaa);

    }

    public void Base(TextView aaa) {
        MyDatabaseHelper dbAss = new MyDatabaseHelper(this);
        MyDB MyDBA = new MyDB(this);
        spin = findViewById(R.id.spinnerCategories);
        aaa.setText(MyDBA.selectRecords().getString(1));
        Spinner desplegable = (Spinner) this.findViewById(R.id.spinnerCategories);

        Cursor cur = MyDBA.selectRecords();
        startManagingCursor(cur);
        String[] from = new String[]{"name"};
        int[] to = new int[]{android.R.id.text1};
        SimpleCursorAdapter adapta = new SimpleCursorAdapter(this,android.R.layout.simple_spinner_dropdown_item,cur,from,to);
        ArrayAdapter<CharSequence> adapter;

        adapta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        desplegable.setAdapter(adapta);
    }
}
