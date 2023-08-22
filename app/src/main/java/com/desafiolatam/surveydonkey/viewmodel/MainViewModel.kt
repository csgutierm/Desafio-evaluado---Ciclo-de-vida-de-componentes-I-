package com.desafiolatam.surveydonkey.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.desafiolatam.surveydonkey.ui.*

class MainViewModel : ViewModel() {

    private var firstAnswer: ArrayList<String> = arrayListOf()
    private var secondAnswer: ArrayList<String> = arrayListOf()
    private var thirdAnswer: ArrayList<String> = arrayListOf()
    private var fourthAnswer: String = ""

    private val separator = ", "

    private var userEmail : String? = null
    private var userSuggest: String? = null

    private val emailAnswer = MutableLiveData<String>()
/*
    fun setEmailAnswer(email: String) {
        emailAnswer.value = email
    }
*/

    fun addFirstAnswer(value: String): List<String> {
        Log.i("addFirstAnswerMainIf", value)
        if (!firstAnswer.contains(value)) {
            firstAnswer.add(value)
        }
        Log.i("addFirstAnswerMainIfEND", firstAnswer.toString())
        return firstAnswer.distinct().sorted().toList()
    }


    fun removeFirstAnswer(value: String): List<String> {
        if (firstAnswer.contains(value)) {
            firstAnswer.remove(value)
        }
        return firstAnswer.sorted().toList()
    }


    fun addSecondAnswer(value: String): List<String> {
        if (!secondAnswer.contains(value)) {
            secondAnswer.add(value)
        }
        return secondAnswer.distinct().sorted().toList()
    }


    fun removeSecondAnswer(value: String): List<String> {
        if (secondAnswer.contains(value)) {
            secondAnswer.remove(value)
        }
        return secondAnswer.sorted().toList()
    }


    fun addThirdAnswer(value: String): List<String> {
        if (!thirdAnswer.contains(value)) {
            thirdAnswer.add(value)
            Log.i("addFirstAnswerMainIf", value)
        }
        Log.i("addFirstAnswerMainIfEND", thirdAnswer.toString())
        return thirdAnswer.distinct().sorted().toList()
    }

    fun removeThirdAnswer(value: String): List<String> {
        if (thirdAnswer.contains(value)) {
            thirdAnswer.remove(value)
        }
        return thirdAnswer.sorted().toList()
    }
/*
    fun addFourthAnswer(value: String): String {
        fourthAnswer = value
        return fourthAnswer
    }

*/

    fun getFirstResult(): String =
        when (firstAnswer.size) {
            1 -> "$COLOR ${firstAnswer.joinToString(separator)}"
            else -> "$COLORS ${firstAnswer.joinToString(separator)}"
        }

    /**
     * Muestra el resultado de la segunda pregunta, separado por ","
     */
    fun getSecondResult(): String =
        when (secondAnswer.size) {
            1 -> "$MATERIAL: ${secondAnswer.joinToString(separator)}"
            else -> "$MATERIALS ${secondAnswer.joinToString(separator)}"
        }

    fun getThirdResult(): String =
        when (thirdAnswer.size) {
            1 -> "$COLOR_CORREA: ${thirdAnswer.joinToString(separator)}"
            else -> "$COLORS_CORREAS ${thirdAnswer.joinToString(separator)}"
        }
/*
    fun getFourthResult(): String =
             "$SUGERENCIA: ${fourthAnswer}"
*/


    /**
     * Agrega tus funciones aqui:
     */

    /**
     * Método para guardar el email
     */
    fun saveUserEmail(email: String) {
        userEmail = email
    }

    /**
     * Método para guardar las sugerencias del usuario
     */
    fun saveUserSuggest(suggest: String) {
        userSuggest = suggest
    }

    /**
     * Métodos para acceder al email y sugerencia
     */
    fun getUserEmail(): String = "Email: ${userEmail}"

    fun getUserSuggest(): String = "Sugerencias: ${userSuggest}"
}