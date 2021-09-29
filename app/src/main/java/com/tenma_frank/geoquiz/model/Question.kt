package com.tenma_frank.geoquiz.model

import androidx.annotation.StringRes

data class Question (@StringRes val textResId: Int, val answer: Boolean, var answered: Boolean) {
}