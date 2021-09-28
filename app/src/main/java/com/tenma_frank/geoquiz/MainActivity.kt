package com.tenma_frank.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.tenma_frank.geoquiz.QuestionProvider.Companion.updateQuestion
import com.tenma_frank.geoquiz.QuestionProvider.Companion.questionChecker
import com.tenma_frank.geoquiz.QuestionProvider.Companion.score
import com.tenma_frank.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.questionTextView.text = getString(updateQuestion(1).textResId)

        binding.trueButton.setOnClickListener {
            questionChecker(true, true)
            Toast.makeText(this, score.toString(), Toast.LENGTH_SHORT).show()
        }

        binding.falseButton.setOnClickListener {
            questionChecker(false,false)
            Toast.makeText(this, score.toString(), Toast.LENGTH_SHORT).show()
        }

        binding.nextButton.setOnClickListener {
            binding.questionTextView.text = getString(updateQuestion(1).textResId)
            binding.trueButton.isEnabled = when{
                updateQuestion(0).answered == true -> false
                else -> true
            }

            binding.falseButton.isEnabled = when{
                updateQuestion(0).answered == true -> false
                else -> true
            }


        }

        binding.prevButton.setOnClickListener {
            binding.questionTextView.text = getString(updateQuestion(-1).textResId)
            binding.trueButton.isEnabled = when{
                updateQuestion(0).answered == true -> false
                else -> true
            }
            binding.falseButton.isEnabled = when{
                updateQuestion(0).answered == true -> false
                else -> true
            }
        }

    }

}