package edu.iesam.superheroes.features.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.superheroes.R
import edu.iesam.superheroes.features.data.SuperHeroeDataRepository
import edu.iesam.superheroes.features.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.domain.ErrorApp
import edu.iesam.superheroes.features.domain.GetSuperHeroesUseCase
import edu.iesam.superheroes.features.domain.SuperHeroe

class SuperHeroesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val superHeroesListViewModel: SuperHeroesListViewModel= SuperHeroesListViewModel(
        GetSuperHeroesUseCase(
            SuperHeroeDataRepository(
                SuperHeroesApiRemoteDataSource()
            ))
        )
        val superHeroe = superHeroesListViewModel.getSuperHeroes()
    }

    fun getSuperHeroes(superHeroesListViewModel: SuperHeroesListViewModel){
        val superHeroe = superHeroesListViewModel.getSuperHeroes()
        superHeroe.fold(
            {superHeroe -> printSuperHeroes(superHeroe)},
            {errorApp -> getSuperHeroesOnFailure(errorApp as ErrorApp)
        }
        )
    }

    fun printSuperHeroes(superHeroe: List<SuperHeroe>){
        print(superHeroe)
    }
    fun getSuperHeroesOnFailure(errorApp: ErrorApp) {
        when(errorApp){
            ErrorApp.ApiError -> {print("ERROR: No se han podido obtener los superheroes.")}
        }
    }
}