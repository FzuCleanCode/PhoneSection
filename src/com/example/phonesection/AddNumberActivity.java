package com.example.phonesection;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNumberActivity extends Activity {
	
	private Spinner spin;
	private ArrayAdapter<String> adapter;
	private List<String> data;
	private Button add;
	private EditText name,number;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.add_number_layout);
		
		spin = (Spinner) findViewById(R.id.spinner);
		add = (Button) findViewById(R.id.add);
		name = (EditText)findViewById(R.id.name);
		number = (EditText) findViewById(R.id.number);
		
		//设置spinner的选项
		data = new ArrayList<String>();
		data.add("学校部门");
		data.add("老师号码");
		data.add("订餐热线");
		data.add("个人电话");
		
		adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
		
		//设置按钮点击事件，当点击“确定添加”的按钮，就将添加的信息加入到数据库中
        add.setOnClickListener(new OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				
				
				String str1 = name.getText().toString();
				String str2 = number.getText().toString();
				if("".equals(str1) || "".equals(str2))
				{
					Toast.makeText(AddNumberActivity.this, "Please type completely", Toast.LENGTH_SHORT).show();
				}
				else
				{
					//getParent().finish();
					ContentValues cv = new ContentValues();
					cv.put("name", name.getText().toString());
					cv.put("number", number.getText().toString());
					cv.put("category", spin.getSelectedItem().toString());
					//System.out.println(etName.getText().toString());
					//System.out.println(etSex.getText().toString());
					name.setText("");
					number.setText("");
					
					
					
					MainActivity.dbWrite.insert("user", null, cv);
					
					Intent intent = new Intent(AddNumberActivity.this,MainActivity.class);
//					Intent intent1 = new Intent(AddNumberActivity.this,MainActivity.class);
//					intent1.putExtra("over", "shut dowm");
					getParent().finish();
					startActivity(intent);
					
					finish();
				}
				
				
			}
		});
        
		
		
	}

}
