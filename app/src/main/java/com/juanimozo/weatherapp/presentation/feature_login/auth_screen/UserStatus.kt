package com.juanimozo.weatherapp.presentation.feature_login.auth_screen

sealed class UserStatus() {
    class NotRegistered(): UserStatus()
    class FullyRegistered(): UserStatus()
    class RegisteredWithoutCity(): UserStatus()
}
