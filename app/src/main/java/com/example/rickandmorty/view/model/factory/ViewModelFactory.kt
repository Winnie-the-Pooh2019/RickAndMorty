package com.example.rickandmorty.view.model.factory

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object ViewModelFactory {
    inline fun <reified T : ViewModel> viewModelFactory(
        activity: AppCompatActivity,
        crossinline initializer: () -> T
    ): Lazy<T> {
        return activity.viewModels {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return initializer() as T
                }
            }
        }
    }
}

