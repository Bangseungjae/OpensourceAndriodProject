package bsj.io.exam03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 엑티비티");

        final EditText edtNum1 = findViewById(R.id.edtNum1);
        final EditText edtNum2 = findViewById(R.id.edtNum2);
        final RadioGroup rdoGroup = findViewById(R.id.rdoGroup);
        Button btnNewActivity = findViewById(R.id.btnNewActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                if (rdoGroup.getCheckedRadioButtonId()==R.id.rdoAdd) intent.putExtra("Calc","+");
                else if (rdoGroup.getCheckedRadioButtonId()==R.id.rdoSub) intent.putExtra("Calc","-");
                else if (rdoGroup.getCheckedRadioButtonId()==R.id.rdoMul) intent.putExtra("Calc","*");
                else if (rdoGroup.getCheckedRadioButtonId()==R.id.rdoDiv) intent.putExtra("Calc","/");


                intent.putExtra("Num1",
                        Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",
                        Integer.parseInt(edtNum2.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "결과 :" + hap,
                    Toast.LENGTH_SHORT).show();
        }
    }
}