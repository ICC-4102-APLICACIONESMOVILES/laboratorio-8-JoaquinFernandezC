package cl.magnet.mobileappsexample.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("SELECT * FROM form")
    LiveData<List<Question>> getAllQuestions();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Question... questions);

    @Query("DELETE FROM question")
    void deleteAll();
}
