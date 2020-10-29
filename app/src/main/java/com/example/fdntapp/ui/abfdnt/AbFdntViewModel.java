package com.example.fdntapp.ui.abfdnt;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AbFdntViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AbFdntViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("To jest zakładka o fundacji");
    }

    public LiveData<String> getText() {
        return mText;
    }
}