package com.gzeinnumer.databaselocalmodule.exampleRoom;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.databaselocalmodule.R;
import com.gzeinnumer.databaselocalmodule.exampleRoom.data.AppDatabase;
import com.gzeinnumer.dlm.helper.DataModule;
import com.nambimobile.widgets.efab.FabOption;

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

        FabOption fo1 = findViewById(R.id.fo_1);
        fo1.setOnClickListener(view -> {
            DataModule.newInstanse(this, appDatabase).build();
        });

        FabOption fo2 = findViewById(R.id.fo_2);
        fo2.setOnClickListener(view -> {
            DataModule.newInstanse(this, appDatabase).addTable("sample_table").build();
        });
    }
}