package com.tenma_frank.geoquiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.tenma_frank.geoquiz.model.QuestionProvider.Companion.updateQuestion
import com.tenma_frank.geoquiz.model.QuestionProvider.Companion.questionChecker
import com.tenma_frank.geoquiz.model.QuestionProvider.Companion.score
import com.tenma_frank.geoquiz.R
import com.tenma_frank.geoquiz.databinding.ActivityMainBinding
import com.tenma_frank.geoquiz.viewmodel.QuestionViewModel
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val questionViewModel : QuestionViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        questionViewModel.question.observe(this, Observer {
            binding.questionTextView.text = getString(updateQuestion(1).textResId)
        })

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