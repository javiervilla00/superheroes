package edu.iesam.superheroes.features.data

import edu.iesam.superheroes.features.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.domain.SuperHeroe
import edu.iesam.superheroes.features.domain.SuperHeroeRepository

class SuperHeroeDataRepository (private val superHeroesApiRemoteDataSource: SuperHeroesApiRemoteDataSource) : SuperHeroeRepository{
    override fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return superHeroesApiRemoteDataSource.getSuperHeroes()
    }
}