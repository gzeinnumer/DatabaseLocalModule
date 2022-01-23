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

        Button btnDialog = findViewById(R.id.btn_dialog);
        btnDialog.setOnClickListener(view -> {
            DataModule.newInstanse(this, sqLiteDatabase).addTable("table1","table2").build();
        });
    }
}