package jtphan.csci448.jtphan_a1

class Quiz {
    object Quiz {
        //private val theQuestion = Question(R.string.question1, false)
        private val questionBank: MutableList<Question> = mutableListOf()
        private var score = 0
        private var currentQuestionIndex = 0

        init{
            questionBank.add(Question(R.string.question1, true,1)) //What fruit is yellow...
            questionBank.add(Question(R.string.question_2, true, 0)) //Is Mines hard?
            questionBank.add(Question(R.string.question_3, true, 2)) //What is the name of planet...
        }

        val currentQuestion: Question
            get() = questionBank[currentQuestionIndex]  //Get question from question bank
        val currentQuestionTextId: Int //Get id
            get() = currentQuestion.textResId
        val currentQuestionAnswer: Boolean //Boolean True or false
            get() = currentQuestion.isAnswerTrue
        val currentScore:Int //Get score
            get() = score
        val currentQuestionActivity: Int
            get() = currentQuestion.isAnswerInt



        //Next Question
        fun moveToNextQuestion(){
            if(currentQuestionIndex == questionBank.size - 1){
                currentQuestionIndex = 0
            }else{
                currentQuestionIndex = currentQuestionIndex + 1
            }
        }

        //Previous Question
        fun moveToPreviousQuestion(){
            if(currentQuestionIndex == 0){
                currentQuestionIndex = questionBank.size - 1
            }else{
                currentQuestionIndex = currentQuestionIndex - 1
            }
        }

        //Check if Answer Correct
        fun isAnswerCorrect(isTrue:Boolean): Boolean{
            //if answer param = current answer, increment current score +1
            //return true or false if answer parameter equal current answer
            if(isTrue == currentQuestionAnswer){           //CURRENT ANSWER
                score = currentScore + 1
                return true
            }else{
                return false
            }
        }

        fun currentIndex(): Int{
            return currentQuestionIndex
        }

    }


}