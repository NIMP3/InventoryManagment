package com.yovanydev.data.company.memory;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.yovanydev.entities.company.model.Company;

@Database(entities = {Company.class}, version = 1)
public abstract class CompanyDataBase extends RoomDatabase {
    public abstract ICompanyDao getCompanyDao();
}
