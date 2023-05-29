package com.example.myapplication.unit4.unscramble

data class GameUIState(
    val currentScrambledWord: String = "",
    val isGuessedWordWrong: Boolean = false,
)
