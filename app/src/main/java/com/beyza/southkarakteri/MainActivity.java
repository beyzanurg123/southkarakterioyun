package com.beyza.southkarakteri;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText yasıd;
    TextView sonuc;
    EditText ad;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=this.getSharedPreferences("com.beyza.southkarakteri", Context.MODE_PRIVATE );
        yasıd=findViewById(R.id.editText2);
        sonuc=findViewById(R.id.textView);
        ad=findViewById(R.id.editTextTextPersonName);
        Toast.makeText(MainActivity.this,"tımamm",Toast.LENGTH_LONG);
        int a=sharedPreferences.getInt("strogeage",0);
        if (a==0){
            sonuc.setText("değer - ");
        }
        else{
            sonuc.setText("yaş"+a);
        }

    }
    public void save(View view){
       if(yasıd.getText().toString().matches("")){
           System.out.println("yaş gir");
       }
       else
       {
           int kullnıcıyas=Integer.parseInt(yasıd.getText().toString());
         sonuc.setText("kullanıcı yası"+kullnıcıyas);

           sharedPreferences.edit().putInt("strogeage",kullnıcıyas).apply();
       }

    }
    public void delete(View view){
      int b=sharedPreferences.getInt("strogeage",0);
        if (b!=0){
            sharedPreferences.edit().remove("strogeage").apply();
            sonuc.setText("your age ");
        }
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("sil");
        alert.setMessage("emin misin");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //yes e basarsa kaydet gibi olaylar olur içinde.
                Toast.makeText(MainActivity.this,"tımamm",Toast.LENGTH_LONG);
            }
        });
        alert.show();
}
public void degis(View view){
    String b=ad.getText().toString();
    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
    intent.putExtra("anahtrklme",b);
    startActivity(intent);
}

}