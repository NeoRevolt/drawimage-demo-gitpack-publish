package com.neorevolt.drawimage.filters

import com.neorevolt.drawimage.burhanrashid52.photoeditor.PhotoFilter

interface FilterListener {
    fun onFilterSelected(photoFilter: PhotoFilter?)
}