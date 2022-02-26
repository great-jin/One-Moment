package com.example.register;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Home4Activity extends Activity implements View.OnClickListener{
	
	private EditText m_input;
	private Button m_ok,m_output;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		m_input = (EditText)findViewById(R.id.m_input);
		m_ok = (Button)findViewById(R.id.m_ok);
		m_output = (Button)findViewById(R.id.m_output);
		
		m_ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String message=m_input.getText().toString();
                SharedPreferences pref = Home4Activity.this.getSharedPreferences("data4",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("Content",message);
                editor.commit();
                Toast.makeText(Home4Activity.this, "写入成功" , Toast.LENGTH_LONG).show();
                m_input.setText("");
			}
		});
		
		m_output.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				SharedPreferences pre = getSharedPreferences("data4",MODE_PRIVATE);
                String mess = pre.getString("Content","");
                m_input.setText(mess);
                Toast.makeText(Home4Activity.this, "读取成功" , Toast.LENGTH_LONG).show();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
