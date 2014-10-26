package wojtek.acivitysimplecommunicationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        TextView textView=(TextView)findViewById(R.id.textFirst);
        textView.setText(doOnExtraRecive(savedInstanceState));

        Button button=(Button)findViewById(R.id.buttonFirst);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIntentWithText();
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        TextView textView=(TextView)findViewById(R.id.textFirst);
        textView.setText(doOnExtraRecive(intent.getExtras()));
    }

    private void openIntentWithText(){
        EditText editText=(EditText)findViewById(R.id.editFirst);
        Intent intent=new Intent(getApplicationContext(),SecondActiv.class);
        intent.putExtra("message",editText.getText().toString());

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent);
    }


    private String doOnExtraRecive(Bundle savedInstanceState){
        String newString;
        if (savedInstanceState == null) {
            Bundle extras= getIntent().getExtras();
            if(extras == null) {
              return   newString= "";
            } else {
                return  newString= extras.getString("message");
            }
        } else {
            return newString= (String) savedInstanceState.getSerializable("message");
        }
    }

}
