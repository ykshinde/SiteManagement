package com.example.ykshinde.sitemanagement.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class LabourDetails {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public LabourDetails(String word) {this.mWord = word;}

    public String getWord(){return this.mWord;}
}