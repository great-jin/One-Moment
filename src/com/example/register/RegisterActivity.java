package com.example.register;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity{

	private EditText re_name,password2,password3;
	private Button register2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		re_name = (EditText)findViewById(R.id.re_name);
		password2 = (EditText)findViewById(R.id.password2);		//����
		password3 = (EditText)findViewById(R.id.password3);		//ȷ������
		register2 = (Button)findViewById(R.id.register2);
		
		register2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = re_name.getText().toString();			//�û���
				String pwd = password2.getText().toString();		//����
				String pwd2 = password3.getText().toString();		//ȷ������
				
				if(TextUtils.isEmpty(name)){
					re_name.setError("�û�������Ϊ��");
				}
				else if(TextUtils.isEmpty(pwd)){
					password2.setError("���벻��Ϊ��");
				}
				else if(pwd.length()<6){
					password2.setError("���벻��������λ��");
				}
				else if(pwd.equals(pwd2) ){
					Dbhelper helper=new Dbhelper(RegisterActivity.this,1);
					SQLiteDatabase db=helper.getWritableDatabase();
					
					db.execSQL("insert into userinfo(name,pwd) values(?,?)",new Object[]{name,pwd});
					db.close();
					
					re_name.setText(null);
		            password2.setText(null);
		            password3.setText(null);
		            
		            Toast.makeText(RegisterActivity.this, "ע��ɹ�", Toast.LENGTH_LONG).show();
				}
				else{
					password3.setError("���벻һ��");
				}
			}
		});
	}
}
