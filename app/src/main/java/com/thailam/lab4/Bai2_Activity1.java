package com.thailam.lab4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai2_Activity1 extends AppCompatActivity {

    public static String KEY_NAMEBOOK = "name_book";
    public boolean ischuoi(String str){
        return str.matches("[a-z A-Z 0-9]+");
    }
    TextView txttrave_gia;

    ActivityResultLauncher<Intent> getdata = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 10) {
                        Intent intent = result.getData();
                        if (intent != null) {
                            Bundle bundle = intent.getExtras();
                            String gia = bundle.getString("price");
                            txttrave_gia.setText(gia);
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2_activity1);

        txttrave_gia = findViewById(R.id.txttrave_gia);
        EditText edtname_book = findViewById(R.id.edtname_book);
        Button btngui_gia = findViewById(R.id.btngui);

        btngui_gia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_book = edtname_book.getText().toString();
                if (name_book.trim().isEmpty()) {
                    Toast.makeText(Bai2_Activity1.this, "Khong duoc bo trong", Toast.LENGTH_SHORT).show();
                }else if(!ischuoi(name_book)){
                    Toast.makeText(Bai2_Activity1.this, "Nhap sai dinh dang ten", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Bai2_Activity1.this, Bai2_Activity2.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_NAMEBOOK, name_book);
                    intent.putExtras(bundle);
                    getdata.launch(intent);
                }
            }
        });
    }
}