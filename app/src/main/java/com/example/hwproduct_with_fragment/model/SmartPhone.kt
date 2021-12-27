package com.example.hwproduct_with_fragment.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SmartPhone(
    @DrawableRes val prductPic :Int,
    @StringRes val PhoneName : Int,
    val PhonePrice :String,
    val PhoneVip :Boolean,
    val PhoneQuantity :Int

)