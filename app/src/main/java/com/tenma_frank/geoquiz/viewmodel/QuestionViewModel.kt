package com.tenma_frank.geoquiz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tenma_frank.geoquiz.model.Question
import com.tenma_frank.geoquiz.model.QuestionProvider

class QuestionViewModel : ViewModel() {

    val question = MutableLiveData<Question>()

    fun updatedQuestion(){
        val currentQuestion : Question = QuestionProvider.updateQuestion(1)
        question.postValue(currentQuestion);
    }

}