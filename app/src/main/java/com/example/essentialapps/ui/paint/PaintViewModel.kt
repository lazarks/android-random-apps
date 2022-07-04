package com.example.essentialapps.ui.paint

import android.content.Context
import android.graphics.Color
import android.graphics.Path
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PaintViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Paint Fragment"
    }
    val text: LiveData<String> = _text
}