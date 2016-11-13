package monty.nots;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import monty.nots.database.Note;

/**
 * Created by monty on 12/11/16.
 */
public class CustomAdapter extends ArrayAdapter<Note> {

    List<Note> dbentries;

    public CustomAdapter(Context context,List<Note> objects) {
        super(context,0, objects);
        this.dbentries = objects;
    }

    @Override
    public View getView(int pos,View view,ViewGroup container){

        Note note = getItem(pos);
        String notingvalue = dbentries.get(pos).getNote();
        View root = view;
        if(root == null){
            root = LayoutInflater.from(container.getContext()).inflate(R.layout.row,container,false);
        }

        TextView read = (TextView) root.findViewById(R.id.textout);
        Button remove = (Button)  root.findViewById(R.id.remove);

        read.setText(notingvalue);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return root;
    }



}
