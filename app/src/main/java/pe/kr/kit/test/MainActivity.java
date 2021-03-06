package pe.kr.kit.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pe.kr.kit.test.enums.LoginStatus;
import pe.kr.kit.test.exception.LoginException;
import pe.kr.kit.test.exception.MyException;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    String expectedId = "test";
    String expectedPwd = "1234";

    EditText etId, etPwd;

   LoginStatus status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView는 화면을 그릴때 뷰를 지정하는 것
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        etPwd = findViewById(R.id.etPwd);
        //이벤트를 만들려고 하면
        //1. 버튼을 넣는다
        Button btn = findViewById(R.id.btn_Login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etId.getText().toString();
                String pwd = etPwd.getText().toString();

                try {
                    if(id.equals(expectedId) && pwd.equals(expectedPwd)) {
                        Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT);
                        status = LoginStatus.SUCCESS;
                    } else {
                        if(!id.equals(expectedId)) {
                            status = LoginStatus.ID_ERROR;
                            throw new LoginException(LoginStatus.ID_ERROR);
                        }
                        if(!pwd.equals(expectedPwd)) {
                            status = LoginStatus.PWD_ERROR;
                            throw new LoginException(LoginStatus.PWD_ERROR);
                        }
                    }
                }
                catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                } finally {
                    Log.d("TEST", "current status => " + status);
                    //로그인 성공 되고 화면 이동
                    //DashboardAcitivity로 이동
                    //화면 이동시 intent를 통해서 이동이 가능
                    //조건은 로그인이 성공됐을 경우
                    if(status.equals(LoginStatus.SUCCESS)) {
                        Log.d("TEST", "로그인 성공");
                        // 화면 이동 처리
                        Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
                        startActivity(intent);
                    }
                }

            }
        });


    }

}