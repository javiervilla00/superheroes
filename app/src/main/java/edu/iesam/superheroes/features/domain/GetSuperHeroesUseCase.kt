package edu.iesam.superheroes.features.domain

class GetSuperHeroesUseCase (private val superHeroeRepository: SuperHeroeRepository) {
    operator fun invoke() : Result<List<SuperHeroe>>{
        return superHeroeRepository.getSuperHeroes()
    }
}