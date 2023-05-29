package com.thailam.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai2_Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2_activity2);

        TextView txttrave_name = findViewById(R.id.txttrave_ten);
        EditText edtgia = findViewById(R.id.edtgia_book);
        Button btnbaogia = findViewById(R.id.btnbaogia);

        Bundle bundle = getIntent().getExtras();
        txttrave_name.setText(bundle.getString(Bai2_Activity1.KEY_NAMEBOOK));

        btnbaogia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gia = edtgia.getText().toString();
                if(gia.trim().isEmpty()){
                    Toast.makeText(Bai2_Activity2.this, "Khong duoc bo trong", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent();
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("price",gia);
                    intent.putExtras(bundle1);
                    setResult(10,intent);
                    finish();
                }

            }
        });

    }
}