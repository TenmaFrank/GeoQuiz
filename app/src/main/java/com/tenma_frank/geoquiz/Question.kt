package com.tenma_frank.geoquiz

import androidx.annotation.StringRes

data class Question (@StringRes val textResId: Int, val answer: Boolean, var answered: Boolean) {
}