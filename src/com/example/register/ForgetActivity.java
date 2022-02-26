package com.example.register;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetActivity extends Activity {

	private EditText for_name,for_password2,for_password3;
	private Button for_ok;
	Dbhelper helper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forget);
		
		for_name = (EditText)findViewById(R.id.for_name);
		for_password2 = (EditText)findViewById(R.id.for_password2);		//新密码
		for_password3 = (EditText)findViewById(R.id.for_password3);		//确认密码
		for_ok = (Button)findViewById(R.id.for_ok);
		
		for_ok.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String name = for_name.getText().toString();			//用户名
				String pwd = for_password2.getText().toString();		//密码
				String pwd2 = for_password3.getText().toString();		//确认密码

				Dbhelper helper = new Dbhelper(ForgetActivity.this, 1);
				SQLiteDatabase db = helper.getReadableDatabase();
				
				if(TextUtils.isEmpty(name)){
					for_name.setError("用户名不能为空");
				}
				else if(TextUtils.isEmpty(pwd)){
					for_password2.setError("密码不能为空");
				}
				else if(pwd.equals(pwd2) ){
					
					db.execSQL("update userinfo set pwd=? where name=?",new Object[]{pwd,name});
					db.close();
					
					for_name.setText(null);
					for_password2.setText(null);
					for_password3.setText(null);
					
					Toast.makeText(ForgetActivity.this, "修改成功", Toast.LENGTH_LONG).show();
				}	
				else{
					for_password3.setError("密码不一致");
				}
				}
		});
	}
}
