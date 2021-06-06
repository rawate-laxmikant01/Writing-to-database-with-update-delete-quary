package com.example.writingthedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.user_id);
        password=findViewById(R.id.password_id);
    }

    public void sendData(View view) {

        String user_name=user.getText().toString().trim();
        String password_name=password.getText().toString().trim();

        DbHelper dbHelper=new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put("username",user_name);
        values.put("password",password_name);

        long rowId=db.insert("user_login",null,values);

        Log.e("Row Id","*********"+rowId );

        Toast.makeText(this, " Data Inserted Sucessfully\n" + user_name + "\n " + password_name + "\n " + rowId, Toast.LENGTH_SHORT).show();
    }

    public void updateData(View view) {
        startActivity(new Intent(MainActivity.this,update.class));
    }
}