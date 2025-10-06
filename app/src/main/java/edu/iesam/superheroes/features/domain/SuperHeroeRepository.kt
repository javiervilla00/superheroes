package edu.iesam.superheroes.features.domain

interface SuperHeroeRepository {
    fun getSuperHeroes() : Result<List<SuperHeroe>>
}