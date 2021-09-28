package com.tenma_frank.geoquiz

class QuestionProvider {

    companion object{

        private var currentIndex = 0
        var score = 0

        private val questionBank = listOf<Question>(
            Question(R.string.question_australia,true,false),
            Question(R.string.question_oceans,true,false),
            Question(R.string.question_mideast,false,false),
            Question(R.string.question_africa,false,false),
            Question(R.string.question_americas,true,false),
            Question(R.string.question_asia,true,false)
        )

        fun updateQuestion(aux: Int): Question {
            currentIndex = when{
                currentIndex < 5 -> currentIndex + aux
                currentIndex >= 5 -> 0
                currentIndex < 0 -> 5
                else -> currentIndex - aux
            }
            return questionBank[currentIndex]
        }

        fun questionChecker(answer: Boolean, answered: Boolean): Boolean {

            questionBank[currentIndex].answered = answered

            if(questionBank[currentIndex].answer == answer){
                score ++
                return true
            }
            else{
                return false
            }

        }

    }
}