package com.edu.vplayer.features.domain.model

data class UserDetails(
    val userNameOrEmailAddress: String,
    val password: String,
    val rememberClient: Boolean,
    val couponCode: String
)

