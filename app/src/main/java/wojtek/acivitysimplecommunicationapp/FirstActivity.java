package wojtek.acivitysimplecommunicationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FirstActivity extends Activity {
    public static final String message = "MESSAGE";
    public static final String message2 = "MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        TextView textView = (TextView) findViewById(R.id.textFirst);
        textView.setText(doOnExtraRecive(savedInstanceState));

        Button button = (Button) findViewById(R.id.buttonFirst);
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

        TextView textView = (TextView) findViewById(R.id.textFirst);
        textView.setText(doOnExtraRecive(intent.getExtras()));
    }

    private void openIntentWithText() {
        EditText editText = (EditText) findViewById(R.id.editFirst);
        EditText editText2 = (EditText) findViewById(R.id.edit2First);
        Intent intent = new Intent(getApplicationContext(), SecondActiv.class);
        intent.putExtra(message, editText.getText().toString());
        intent.putExtra(message2, editText2.getText().toString());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent);

    }


    private String doOnExtraRecive(Bundle savedInstanceState) {
        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = "";
            } else {
                newString = extras.getString(message);
            }
        } else {
            newString = (String) savedInstanceState.getSerializable(message);
        }

        String newString2;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                return newString2 = newString + "";
            } else {
                return newString2 = newString + extras.getString(FirstActivity.message2);
            }
        } else {
            return newString2 = newString + (String) savedInstanceState.getSerializable(FirstActivity.message2);
        }
    }

}
