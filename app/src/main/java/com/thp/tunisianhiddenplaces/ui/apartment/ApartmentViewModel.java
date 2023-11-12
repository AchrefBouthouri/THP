package com.thp.tunisianhiddenplaces.ui.apartment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ApartmentViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ApartmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is apartment fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
