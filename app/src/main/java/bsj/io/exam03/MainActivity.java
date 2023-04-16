package bsj.io.exam03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.idEditText);
        password = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.getText().toString().equals("") || password.getText().toString().equals("")){
                    Toast toast =  Toast.makeText(getApplicationContext(),"아이디와 비밀번호를 입력해주세요!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(id.getText().toString().equals("1234") && password.getText().toString().equals("1234")){
                    Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                    intent.putExtra("id",id.getText().toString());
                    intent.putExtra("password",password.getText().toString());
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast toast =  Toast.makeText(getApplicationContext(),"아이디와 비밀번호가 일치하지 않습니다!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
