package fr.adenlexar.v4.ui.complements;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CompViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CompViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is comp fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}