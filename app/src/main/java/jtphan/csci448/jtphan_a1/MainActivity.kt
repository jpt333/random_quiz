package jtphan.csci448.jtphan_a1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var scoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreTextView = findViewById(R.id.score_text_view)

        val input: EditText = findViewById(R.id.blank_box)

        true_button.setOnClickListener{
            checkAnswer(true)
        }
        false_button.setOnClickListener{
            checkAnswer(false)
        }

        previous_button.setOnClickListener{
            if(Quiz.Quiz.currentIndex() == 0){  //Third question Fill in blank
                first_button.setVisibility(View.INVISIBLE)
                second_button.setVisibility(View.INVISIBLE)
                third_button.setVisibility(View.INVISIBLE)
                fourth_button.setVisibility(View.INVISIBLE)
                true_button.setVisibility(View.INVISIBLE)
                false_button.setVisibility(View.INVISIBLE)
                blank_box.setVisibility(View.VISIBLE)
                submit_button.setVisibility(View.VISIBLE)
            } else if(Quiz.Quiz.currentIndex() == 1){ // 1st question MC
                first_button.setVisibility(View.VISIBLE)
                second_button.setVisibility(View.VISIBLE)
                third_button.setVisibility(View.VISIBLE)
                fourth_button.setVisibility(View.VISIBLE)
                true_button.setVisibility(View.INVISIBLE)
                false_button.setVisibility(View.INVISIBLE)
                blank_box.setVisibility(View.INVISIBLE)
                submit_button.setVisibility(View.INVISIBLE)
            } else{
                first_button.setVisibility(View.INVISIBLE) //Second question true false
                second_button.setVisibility(View.INVISIBLE)
                third_button.setVisibility(View.INVISIBLE)
                fourth_button.setVisibility(View.INVISIBLE)
                true_button.setVisibility(View.VISIBLE)
                false_button.setVisibility(View.VISIBLE)
                blank_box.setVisibility(View.INVISIBLE)
                submit_button.setVisibility(View.INVISIBLE)
            }
            moveToQuestion(-1)
        }


        next_button.setOnClickListener{
            if(Quiz.Quiz.currentIndex() == 0){  //2nd
                first_button.setVisibility(View.INVISIBLE) //Second question true false
                second_button.setVisibility(View.INVISIBLE)
                third_button.setVisibility(View.INVISIBLE)
                fourth_button.setVisibility(View.INVISIBLE)
                true_button.setVisibility(View.VISIBLE)
                false_button.setVisibility(View.VISIBLE)
                blank_box.setVisibility(View.INVISIBLE)
                submit_button.setVisibility(View.INVISIBLE)
            } else if(Quiz.Quiz.currentIndex() == 1){ // 3rd Question //blank box
                first_button.setVisibility(View.INVISIBLE)
                second_button.setVisibility(View.INVISIBLE)
                third_button.setVisibility(View.INVISIBLE)
                fourth_button.setVisibility(View.INVISIBLE)
                true_button.setVisibility(View.INVISIBLE)
                false_button.setVisibility(View.INVISIBLE)
                blank_box.setVisibility(View.VISIBLE)
                submit_button.setVisibility(View.VISIBLE)
            } else{
                first_button.setVisibility(View.VISIBLE) //1st Question MC
                second_button.setVisibility(View.VISIBLE)
                third_button.setVisibility(View.VISIBLE)
                fourth_button.setVisibility(View.VISIBLE)
                true_button.setVisibility(View.INVISIBLE)
                false_button.setVisibility(View.INVISIBLE)
                blank_box.setVisibility(View.INVISIBLE)
                submit_button.setVisibility(View.INVISIBLE)
            }
            moveToQuestion(1)
        }

        first_button.setOnClickListener{
            checkAnswer(true)
        }
        second_button.setOnClickListener{
            checkAnswer(false)
        }
        third_button.setOnClickListener{
            checkAnswer(false)
        }
        fourth_button.setOnClickListener{
            checkAnswer(false)
        }

        submit_button.setOnClickListener{
            val userAnswer = correctFillInBlank(input.text.toString())
            checkAnswer(userAnswer)
        }
        updateQuestion()
    }

    //Set Current Score
    private fun setCurrentScoreText(){
        scoreTextView.text = Quiz.Quiz.currentScore.toString()
    }

    //Update Question
    private fun updateQuestion(){
        setCurrentScoreText()
        question_text_view.text = resources.getString(Quiz.Quiz.currentQuestionTextId)
    }

    //Check Answer
    private fun checkAnswer(bool: Boolean){
        if(Quiz.Quiz.isAnswerCorrect(bool)){
            Toast.makeText(baseContext, "Nice job it's correct!", Toast.LENGTH_SHORT).show()
            setCurrentScoreText()
        }else{
            Toast.makeText(baseContext, "Incorrect!", Toast.LENGTH_SHORT).show()
            setCurrentScoreText()
        }
    }

    private fun moveToQuestion(question: Int){
        if(question > 0){
            Quiz.Quiz.moveToNextQuestion()
        }else{
            Quiz.Quiz.moveToPreviousQuestion()
        }
        updateQuestion()
    }

    private fun correctFillInBlank(reply: String): Boolean{
        if(reply == "Earth" || reply == "earth" || reply == "EARTH"){
            return true
        }
        return false
    }


}
