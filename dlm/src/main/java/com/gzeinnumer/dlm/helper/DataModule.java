package com.gzeinnumer.dlm.helper;

import android.database.sqlite.SQLiteDatabase;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.gzeinnumer.dlm.DialogTable;

public class DataModule {

    private final FragmentActivity fragmentActivity;
    public SQLiteDatabase db;
    private String[] table;

    public static DataModule newInstanse(FragmentActivity fragmentActivity, SQLiteDatabase sqLiteDatabase) {
        return new DataModule(fragmentActivity, sqLiteDatabase);
    }

    public DataModule(FragmentActivity fragmentActivity, SQLiteDatabase sqLiteDatabase) {
        this.fragmentActivity = fragmentActivity;
        this.db = sqLiteDatabase;
    }

    public void build() {
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        Fragment previous = fragmentActivity.getSupportFragmentManager().findFragmentByTag(DialogTable.TAG);
        if(previous != null){
            transaction.remove(previous);
        }
        DialogTable dialog = DialogTable.newInstance(db, table);
        dialog.show(transaction, DialogTable.TAG);
    }

    public DataModule addTable(String... table) {
        this.table = table;
        return this;
    }
}
