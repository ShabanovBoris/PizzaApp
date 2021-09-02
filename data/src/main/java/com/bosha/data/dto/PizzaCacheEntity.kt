package com.bosha.data.dto

import androidx.room.*
import com.bosha.data.db.DbContract

@Entity(tableName = DbContract.TABLE_NAME)
data class PizzaCacheEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbContract.COLUMN_ID)
    val id: Int = 0,
    @ColumnInfo(name = DbContract.TITLE)
    val title: String,
    @ColumnInfo(name = DbContract.IMAGE_RES)
    val imageRes: Int,
    @ColumnInfo(name = DbContract.PRICE)
    val price: Int,
    @ColumnInfo(name = DbContract.DESCRIPTION)
    val description: String,
)





