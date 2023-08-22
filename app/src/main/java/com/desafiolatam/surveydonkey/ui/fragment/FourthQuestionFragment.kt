package com.desafiolatam.surveydonkey.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.desafiolatam.surveydonkey.databinding.FragmentFourthQuestionBinding
import com.desafiolatam.surveydonkey.viewmodel.MainViewModel

class FourthQuestionFragment : Fragment() {

    private var _binding: FragmentFourthQuestionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFourthQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*     binding.run {
    //          answer41.setonc { _, checked ->
    //              if (checked) viewModel.addFourthAnswer(answer41.text.toString())
    //              else viewModel.removeFourthAnswer(answer41.text.toString())
    //          }



              val sugerenciaEditText = view.findViewById<EditText>(R.id.tv_fourth_answer)

              sugerenciaEditText.addTextChangedListener(object : TextWatcher {
                  override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                  }

                  override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                      viewModel.addFourthAnswer(s.toString())
                  }

                  override fun afterTextChanged(s: Editable?) {
                  }


              })


              val emailEditText = view.findViewById<EditText>(R.id.emailEditText)

              emailEditText.addTextChangedListener(object : TextWatcher {
                  override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                  }

                  override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                      viewModel.setEmailAnswer(s.toString())
                  }

                  override fun afterTextChanged(s: Editable?) {
                  }


          })
          }*/


        binding.run {
            answer41.doOnTextChanged { text, _, _, _ ->
                viewModel.saveUserEmail(text.toString())
            }
            answer42.doOnTextChanged { text, _, _, _ ->
                viewModel.saveUserSuggest(text.toString())
            }
        }
    }



  /*  override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}