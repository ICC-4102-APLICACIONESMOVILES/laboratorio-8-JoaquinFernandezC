package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Form.class,
        parentColumns = "uid", childColumns = "formId",
        onDelete = CASCADE))
public class Question {
    @PrimaryKey
    private int uid;
    @ColumnInfo(name = "type")
    private String type;


    @ColumnInfo(name = "text")
    private String text;

    public Question(int uid, String type, String text) {
        this.uid = uid;
        this.text = text;
        this.type = type;
    }

    public int getUid() { return uid; }

    public void setUid(int uid) { this.uid = uid; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}
