package wojtek.acivitysimplecommunicationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        findViewById(R.id.buttonResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResults();

            }
        });
    }

    private void sendResults() {
        EditText edit = (EditText) findViewById(R.id.editResult);
        String text =edit.getText().toString();
        Intent resultIntent=new Intent();
        resultIntent.putExtra(FirstActivity.REQUEST_MESSAGE,text);
        setResult(FirstActivity.GOOD,resultIntent);
        finish();
    }


}
