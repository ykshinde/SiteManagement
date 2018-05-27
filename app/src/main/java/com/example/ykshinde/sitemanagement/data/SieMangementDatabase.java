package com.example.ykshinde.sitemanagement.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {LabourDetails.class}, version = 1)
public abstract class SieMangementDatabase extends RoomDatabase{
    public abstract SiteMangementDao siteMangementDao();

    private static SieMangementDatabase INSTANCE;

    public static SieMangementDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SieMangementDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SieMangementDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

