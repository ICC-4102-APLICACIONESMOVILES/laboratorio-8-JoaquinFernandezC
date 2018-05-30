package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class FormViewModel extends AndroidViewModel {

    private FormRepository mRepository;

    private LiveData<List<Form>> mAllForms;

    public FormViewModel(@NonNull Application application) {
        super(application);
        mRepository = new FormRepository(application);
        mAllForms = mRepository.getAllForms();
    }

    public LiveData<List<Form>> getAllForms() {
        return mAllForms;
    }

    public void insert(List<Form> forms) {
        mRepository.insert(forms);
    }
}
