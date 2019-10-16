package club.lanhaoo.silence.leftpanel;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import club.lanhaoo.silence.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("");


        CheckBox checkBox_rememberPasswd=(CheckBox)findViewById(R.id.checkBox_remeber_passwd);
        checkBox_rememberPasswd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getApplicationContext(),"记住密码",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"不记住密码",Toast.LENGTH_LONG).show();
                }
            }
        });

        Button button_login= (Button)findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),R.string.login_button_login,Toast.LENGTH_LONG).show();
            }
        });

        Button button_signUp= (Button)findViewById(R.id.button_signup);
        button_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),R.string.login_button_signup,Toast.LENGTH_LONG).show();
            }
        });



    }

}
