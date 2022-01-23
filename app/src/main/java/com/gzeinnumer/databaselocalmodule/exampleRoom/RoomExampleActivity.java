package com.gzeinnumer.databaselocalmodule.exampleRoom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

import com.gzeinnumer.databaselocalmodule.R;
import com.gzeinnumer.databaselocalmodule.exampleRoom.data.AppDatabase;
import com.gzeinnumer.databaselocalmodule.exampleRoom.entity.SampleTable;
import com.gzeinnumer.databaselocalmodule.exampleSQLite.SqliteExampleActivity;
import com.gzeinnumer.dlm.helper.DataModule;

public class RoomExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_example);

        setTitle("Room");

        AppDatabase db = AppDatabase.getDatabase(getApplicationContext());

        //insert data
//        db.noteDao().insertAll(new SampleTable(1, "data"));
//        db.noteDao().insertAll(new SampleTable(2, "data"));
//        db.noteDao().insertAll(new SampleTable(3, "data"));
//        db.noteDao().insertAll(new SampleTable(4, "data"));
//        db.noteDao().insertAll(new SampleTable(5, "data"));

        SQLiteDatabase appDatabase = AppDatabase.getDatabase(getApplicationContext()).getSQLiteDB(getApplicationContext());

        Button btnDialog = findViewById(R.id.btn_dialog);
        btnDialog.setOnClickListener(view -> {
            DataModule.newInstanse(this, appDatabase).build();
        });
    }
}