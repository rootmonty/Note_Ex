package monty.nots;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import monty.nots.database.DbHandler;

public class MainActivity extends Activity {

    EditText textIn;
    Button buttonAdd;
    LinearLayout container;
    DbHandler dbhandler;
    CustomAdapter adapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbhandler = new DbHandler(this);
        listview = (ListView) findViewById(R.id.list);
        textIn = (EditText) findViewById(R.id.textin);
        buttonAdd = (Button) findViewById(R.id.add);
        container = (LinearLayout) findViewById(R.id.container);
        buttonAdd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                dbhandler.addnote(textIn.getText().toString());
            }
        });

        adapter = new CustomAdapter(this,dbhandler.getAll());
        listview.setAdapter(adapter);

    }
}


