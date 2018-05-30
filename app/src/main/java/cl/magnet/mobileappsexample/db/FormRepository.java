package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class FormRepository {

    private FormDao mFormDao;
    private LiveData<List<Form>> mAllForms;

    FormRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mFormDao = db.formDao();
        mAllForms = mFormDao.getAllForms();
    }

    LiveData<List<Form>> getAllForms() {
        return mAllForms;
    }

    public void insert (List<Form> forms) {
        Form[] formsArray = new Form[forms.size()];
        formsArray = forms.toArray(formsArray);
        new insertAsyncTask(mFormDao).execute(formsArray);
    }

    private static class insertAsyncTask extends AsyncTask<Form, Void, Void> {

        private FormDao mAsyncTaskDao;

        insertAsyncTask(FormDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Form... params) {
            mAsyncTaskDao.insertAll(params);
            return null;
        }
    }
}
