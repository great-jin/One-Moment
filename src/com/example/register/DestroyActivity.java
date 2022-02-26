package com.example.register;

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
import android.widget.Toast;

public class DestroyActivity extends Activity {

	private EditText de_name,de_password2,de_password3;
	private Button de_ok;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_destroy);
		
		de_name = (EditText)findViewById(R.id.de_name);
		de_password2 = (EditText)findViewById(R.id.de_password2);		//密码
		de_password3 = (EditText)findViewById(R.id.de_password3);		//确认密码
		de_ok = (Button)findViewById(R.id.de_ok);
	
		de_ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = de_name.getText().toString();			//用户名
				String pwd = de_password2.getText().toString();		//密码
				String pwd2 = de_password3.getText().toString();		//确认密码

				Dbhelper helper = new Dbhelper(DestroyActivity.this, 1);
				SQLiteDatabase db = helper.getReadableDatabase();
				
				
				if(TextUtils.isEmpty(name)){
					de_name.setError("用户名不能为空");
				}
				else if(TextUtils.isEmpty(pwd)){
					de_password2.setError("密码不能为空");
				}
				else if(pwd.equals(pwd2) ){

			        db.execSQL("delete from userinfo where name=?",new Object[]{name});
					db.close();
					
					de_name.setText(null);
					de_password2.setText(null);
					de_password3.setText(null);
					
					Toast.makeText(DestroyActivity.this, "注销成功", Toast.LENGTH_LONG).show();
				}	
				else{
					de_password3.setError("密码不一致");
				}
			}
		});
	}
}
