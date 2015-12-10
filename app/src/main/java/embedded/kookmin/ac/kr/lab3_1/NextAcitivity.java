package embedded.kookmin.ac.kr.lab3_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by JooHo on 2015-11-25.
 */
public class NextAcitivity extends Activity {
    EditText mEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        mEdit = (EditText)findViewById(R.id.stredit);

        Intent intent = getIntent(); //전달된 인텐트
        mEdit.setText(intent.getStringExtra("TextIn")); //인텐트 내용물 get

        Button btnOK = (Button)findViewById(R.id.ok);
        btnOK.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("TextOut", mEdit.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button btnCancel = (Button)findViewById(R.id.cancel);
        btnCancel.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

}
