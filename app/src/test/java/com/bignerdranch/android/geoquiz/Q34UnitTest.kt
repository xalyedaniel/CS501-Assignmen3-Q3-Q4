package com.bignerdranch.android.geoquiz

import androidx.lifecycle.SavedStateHandle
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Q34UnitTest {

    @Test
    //Instrumented Test for Q3
    fun initialCheatState() {
        val savedStateHandle = SavedStateHandle()
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(false, quizViewModel.isCheater)
    }

    @Test
    //Instrumented Test for Q4
    fun cheatStateForNextQuestion() {
        val savedStateHandle = SavedStateHandle()
        val quizViewModel = QuizViewModel(savedStateHandle)
        quizViewModel.isCheater = true
        quizViewModel.moveToNext()
        assertEquals(false, quizViewModel.isCheater)
    }
}
