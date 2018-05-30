package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Question.class,
        parentColumns = "uid", childColumns = "questionId",
        onDelete = CASCADE))
public class Answer {
    @PrimaryKey
    private int uid;
    @ColumnInfo(name = "answer")
    private String answer;


    public Answer(int uid, String answer) {
        this.uid = uid;
        this.answer = answer;
    }

    public int getUid() { return uid; }

    public void setUid(int uid) { this.uid = uid; }

    public String getAnswer() { return answer; }

    public void setAnswer(String answer) { this.answer = answer; }
}

