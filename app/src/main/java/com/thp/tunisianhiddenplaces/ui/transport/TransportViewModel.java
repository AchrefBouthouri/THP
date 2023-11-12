package com.thp.tunisianhiddenplaces.ui.transport;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TransportViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TransportViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is transport fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
