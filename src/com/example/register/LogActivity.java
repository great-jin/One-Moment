package com.example.register;

import java.util.Currency;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogActivity extends Activity {

	private TextView forget,destroy;
	private EditText log_name,password;
	private Button login;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        
        forget = (TextView)findViewById(R.id.forget);
        destroy = (TextView)findViewById(R.id.destroy);
        log_name = (EditText)findViewById(R.id.log_name);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        
        login.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String username = log_name.getText().toString();
				String pwd = password.getText().toString();
				Dbhelper helper = new Dbhelper(LogActivity.this, 1);
				SQLiteDatabase db = helper.getReadableDatabase();
				String sql="select * from userinfo where name='"+username+
						"' and pwd='"+pwd+"' ";
				Log.e("sql",sql);
				Cursor cs=db.rawQuery(sql, null);
				if(TextUtils.isEmpty(username)==false && TextUtils.isEmpty(pwd)==false){
					if(cs.getCount()!=0){
						Intent intent=new Intent(LogActivity.this,ListActivity.class);
						startActivity(intent);
						finish();
					}
					else{
						Toast.makeText(LogActivity.this, "输入有误，请再次输入", Toast.LENGTH_LONG).show();
					}
				}
				else{
					Toast.makeText(LogActivity.this, "输入有误，请再次输入", Toast.LENGTH_LONG).show();
				}
			}
		});
        
        forget.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(LogActivity.this,ForgetActivity.class);
				startActivity(intent);
			}
		});
        
        destroy.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(LogActivity.this,DestroyActivity.class);
				startActivity(intent);
			}
		});
    }
}
