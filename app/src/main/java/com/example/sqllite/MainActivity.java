package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView aaa;

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
        aaa.setText(MyDBA.selectRecords().getString(1));
        Spinner desplegable = (Spinner) this.findViewById(R.id.spinnerCategories);

        Cursor cur = MyDBA.selectRecords();
        startManagingCursor(cur);
        String[] from = new String[]{"name"};
    }
}
