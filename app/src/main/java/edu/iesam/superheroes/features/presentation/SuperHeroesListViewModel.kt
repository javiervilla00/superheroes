package edu.iesam.superheroes.features.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.superheroes.features.domain.GetSuperHeroesUseCase
import edu.iesam.superheroes.features.domain.SuperHeroe

class SuperHeroesListViewModel(private val getSuperHeroes: GetSuperHeroesUseCase) : ViewModel() {
    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return getSuperHeroes.invoke()
    }
}