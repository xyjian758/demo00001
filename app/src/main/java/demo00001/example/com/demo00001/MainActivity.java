package demo00001.example.com.demo00001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import demo00001.example.com.demo00001.widge.InputEditText;
import demo00001.example.com.demo00001.widge.MyEditText;

public class MainActivity extends AppCompatActivity {

    private InputEditText edittext01;
    private MyEditText edittext02;
    private InputEditText passwordInputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        toolbar.setTitle("这里是Title");
        toolbar.setSubtitle("这里是子标题");
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setLogoDescription("setLogoDescription");
        setSupportActionBar(toolbar);*/

        edittext01 = (InputEditText) findViewById(R.id.edittext01);
        edittext02 = (MyEditText) findViewById(R.id.edittext02);
        passwordInputView = (InputEditText) findViewById(R.id.passwordInputView);
        edittext01.setIWatchLetterNum(new InputEditText.IWatchLetterNum() {
            @Override
            public void is4Letter(Boolean b, String text) {
                if(b){
                    Toast.makeText(MainActivity.this,"密码够了",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
