package edu.iesam.superheroes.data.remote

import edu.iesam.superheroes.domain.SuperHeroe

class SuperHeroesApiRemoteDataSource {
    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return Result.success(listOf(SuperHeroe("")))
    }
}