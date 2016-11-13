package monty.nots.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by monty on 10/11/16.
 */
public class DbHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "notes";
    public static final int DB_VERSION = 1 ;
    public static final String TABLE = "note";
    public static final String COL_ID = "id";
    public static final String COL_NOTE = "content";


    public DbHandler(Context context) {
        super(context, DB_NAME , null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE "+TABLE+" ( "+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_NOTE+" TEXT NOT NULL "+" )";
        sqLiteDatabase.execSQL(create);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addnote(String note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NOTE,note);
        db.insert(TABLE,null,cv);
    }

    public List<Note> getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE,null);
        List<Note> notes = new ArrayList<>();

        if(c.moveToFirst()) {
            do {
                Note note = new Note(Integer.parseInt(c.getString((c.getColumnIndex("id")))),
                        c.getString(c.getColumnIndex("content")));
                notes.add(note);
            }
            while (c.moveToNext());

        }
        c.close();
        return notes;
    }

    public String getNote(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(TABLE,new String[]{COL_ID,COL_NOTE},COL_ID+"=?",new String[]{String.valueOf(id)},
                null,null,null,null);
        if(c != null)
            c.moveToFirst();
        if(c.getCount() > 0) {
            Note note = new Note(c.getInt(c.getColumnIndex("id")), c.getString(c.getColumnIndex("content")));
            c.close();
            return note.getNote();
        }
        return "Check the database" ;

    }

}
