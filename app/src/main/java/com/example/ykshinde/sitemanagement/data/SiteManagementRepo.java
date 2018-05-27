package com.example.ykshinde.sitemanagement.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class SiteManagementRepo {
    private SiteMangementDao mWordDao;
    private LiveData<List<LabourDetails>> mAllWords;

    public SiteManagementRepo(Application application) {
        SieMangementDatabase db = SieMangementDatabase.getDatabase(application);
        mWordDao = db.siteMangementDao();
        //mAllWords = mWordDao.getAllLabourDetails();
    }

    public LiveData<List<LabourDetails>> getAllLabourDetails() {
        return mAllWords;
    }


    public void insert (LabourDetails word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<LabourDetails, Void, Void> {

        private SiteMangementDao mAsyncTaskDao;

        insertAsyncTask(SiteMangementDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final LabourDetails... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
