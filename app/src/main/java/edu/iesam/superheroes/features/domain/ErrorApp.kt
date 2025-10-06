package edu.iesam.superheroes.features.domain

sealed class ErrorApp : Throwable() {
    object ApiError : ErrorApp()
}