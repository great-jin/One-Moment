package com.example.register;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{

	private Button m_login,m_register;
	private TextView presentation;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		m_login = (Button)findViewById(R.id.m_login);
		m_register = (Button)findViewById(R.id.m_register);
		presentation = (TextView)findViewById(R.id.presentation);
		
		m_login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,LogActivity.class);
				startActivity(intent);
			}
		});
		m_register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
		presentation.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,PresentationActivity.class);
				startActivity(intent);
			}
		});
	}
}
