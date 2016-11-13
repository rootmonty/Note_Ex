package monty.nots.database;

/**
 * Created by monty on 10/11/16.
 */
public class Note {
    int id;
    String note;

    public Note(){}

    public Note(int id,String note){
        this.id = id ;
        this.note = note;
    }
    public Note(String note){
        this.note = note;

    }
    public int getId(){
        return id;
    }
    public String getNote(){
        return note;
    }
}
