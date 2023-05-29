package com.thailam.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thailam.lab4.R;

public class DangKy_Activity extends AppCompatActivity {

    public static String KEY_USERNAME = "username";
    public static String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        EditText edtname_signup = findViewById(R.id.edtname_signup);
        EditText edtpass_singup = findViewById(R.id.edtpass_Signup);
        EditText edtnhaplai = findViewById(R.id.edtnhaplai_signup);
        Button btndangky = findViewById(R.id.btndangky_signup);


        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtname_signup.getText().toString();
                String password = edtpass_singup.getText().toString();
                String nhaplai = edtnhaplai.getText().toString();
                if (username.trim().isEmpty()) {
                    Toast.makeText(DangKy_Activity.this, "Vui long nhap username", Toast.LENGTH_SHORT).show();
                } else if (password.trim().isEmpty()) {
                    Toast.makeText(DangKy_Activity.this, "Vui long nhap password", Toast.LENGTH_SHORT).show();
                } else if (nhaplai.trim().isEmpty()) {
                    Toast.makeText(DangKy_Activity.this, "Vui long nhap lai password", Toast.LENGTH_SHORT).show();
                } else if (!nhaplai.equals(password)) {
                    Toast.makeText(DangKy_Activity.this, "Password nhap lai khong khop", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(DangKy_Activity.this, com.Thailam.dev.lab4.DangNhapActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_USERNAME, username);
                    bundle.putString(KEY_PASSWORD, password);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

    }
}