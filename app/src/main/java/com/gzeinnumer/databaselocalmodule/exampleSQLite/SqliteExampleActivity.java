package com.gzeinnumer.databaselocalmodule.exampleSQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

import com.gzeinnumer.databaselocalmodule.R;
import com.gzeinnumer.databaselocalmodule.exampleRoom.data.AppDatabase;
import com.gzeinnumer.databaselocalmodule.exampleSQLite.data.DBInstance;
import com.gzeinnumer.databaselocalmodule.exampleSQLite.entity.Table1;
import com.gzeinnumer.dlm.helper.DataModule;
import com.nambimobile.widgets.efab.FabOption;
import com.nambimobile.widgets.efab.FabOption;

public class SqliteExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_example);

        setTitle("Sqlite");

        SQLiteDatabase sqLiteDatabase = DBInstance.getDataBase(getApplicationContext());

        //insert data
//        Table1 table1 = new Table1(sqLiteDatabase);
//        table1.insert();
//        table1.insert();
//        table1.insert();
//        table1.insert();
//        table1.insert();

        FabOption fo1 = findViewById(R.id.fo_1);
        fo1.setOnClickListener(view -> {
            DataModule.newInstanse(this, sqLiteDatabase).build();
        });

        FabOption fo2 = findViewById(R.id.fo_2);
        fo2.setOnClickListener(view -> {
            DataModule.newInstanse(this, sqLiteDatabase).addTable("table1").build();
        });
    }
}