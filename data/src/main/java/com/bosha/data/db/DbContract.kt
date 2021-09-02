package com.bosha.data.db

import android.provider.BaseColumns

object DbContract {
    const val DATABASE_NAME = "pizza.db"

    const val TABLE_NAME = "pizza_cache"
    const val TITLE = "title"
    const val PRICE = "price"
    const val IMAGE_RES = "image_res"
    const val COLUMN_ID = TABLE_NAME + BaseColumns._ID
    const val DESCRIPTION = "description"
}