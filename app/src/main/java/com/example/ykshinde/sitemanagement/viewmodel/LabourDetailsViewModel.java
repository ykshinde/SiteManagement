package com.example.ykshinde.sitemanagement.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.ykshinde.sitemanagement.data.LabourDetails;
import com.example.ykshinde.sitemanagement.data.SiteManagementRepo;

import java.util.List;

public class LabourDetailsViewModel extends AndroidViewModel {

    private SiteManagementRepo mRepository;

    private LiveData<List<LabourDetails>> mAllWords;

    public LabourDetailsViewModel (Application application) {
        super(application);
        mRepository = new SiteManagementRepo(application);
        mAllWords = mRepository.getAllLabourDetails();
    }

    LiveData<List<LabourDetails>> getAllWords() { return mAllWords; }

    public void insert(LabourDetails word) { mRepository.insert(word); }
}