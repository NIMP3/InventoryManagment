package com.yovanydev.data.company.memory;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yovanydev.entities.company.model.Company;

@Dao
interface ICompanyDao {
    @Query("SELECT * FROM "+ Company.TABLE_NAME + " LIMIT 1")
    Company getCompany();

    @Insert
    void addCompany(Company company);

    @Delete
    void deleteCompany(Company company);

    @Update
    void updateCompany(Company company);
}
