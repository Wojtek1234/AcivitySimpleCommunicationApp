package wojtek.acivitysimplecommunicationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActiv extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        TextView textView=(TextView)findViewById(R.id.textSecond);
        textView.setText(doOnExtraRecive(savedInstanceState));
        Button button=(Button)findViewById(R.id.buttonSecond);
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

        TextView textView=(TextView)findViewById(R.id.textSecond);
        textView.setText(doOnExtraRecive(intent.getExtras()));
    }
    private void openIntentWithText(){
        EditText editText=(EditText)findViewById(R.id.editSecond);
        Intent intent=new Intent(getApplicationContext(),FirstActivity.class);
        intent.putExtra("message",editText.getText().toString());

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        getApplicationContext().startActivity(intent);
        finish();
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
