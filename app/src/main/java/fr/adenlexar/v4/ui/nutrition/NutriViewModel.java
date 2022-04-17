package fr.adenlexar.v4.ui.nutrition;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NutriViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NutriViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is nutri fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}