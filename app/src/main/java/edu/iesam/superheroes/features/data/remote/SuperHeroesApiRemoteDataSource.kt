package edu.iesam.superheroes.features.data.remote

import edu.iesam.superheroes.features.domain.ErrorApp
import edu.iesam.superheroes.features.domain.SuperHeroe

class SuperHeroesApiRemoteDataSource {
    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        val superHeroes = listOf<SuperHeroe>(
            SuperHeroe("1", "name1", "slug1", "url1"),
            SuperHeroe("2", "name2", "slug2", "url2")
        )
        if (superHeroes != null) {
            return Result.success(superHeroes)
        }
        return Result.failure(ErrorApp.ApiError)
    }
}