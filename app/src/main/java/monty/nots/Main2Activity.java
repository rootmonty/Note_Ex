package monty.nots;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import monty.nots.database.DbHandler;

/**
 * Created by monty on 10/11/16.
 */
public class Main2Activity extends MainActivity {


    DbHandler db = new DbHandler(this);
    TextView tv1,tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dblayout);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        //int id = Integer.valueOf(viewid);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv1.setText(id+"");
        tv2.setText(db.getNote(id));

    }
}
