package com.norm.mycustomnavtypes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.norm.mycustomnavtypes.ui.theme.MyCustomNavTypesTheme
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
data object CatListRoute

@Serializable
data class CatDetailRoute(
    val cat: Cat,
    val breedSize: BreedSize,
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCustomNavTypesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = CatListRoute,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = innerPadding.calculateTopPadding(),
                                bottom = innerPadding.calculateBottomPadding(),
                            )
                    ) {
                        composable<CatListRoute> {
                            CatListScreen(
                                onCatClick = { cat, breedSize ->
                                    navController.navigate(
                                        CatDetailRoute(
                                            cat = cat,
                                            breedSize = breedSize,
                                        )
                                    )
                                }
                            )
                        }
                        composable<CatDetailRoute>(
                            typeMap = mapOf(
                                typeOf<Cat>() to CustomNavType.CatType,
                                typeOf<BreedSize>() to NavType.EnumType(BreedSize::class.java)
                            )
                        ) {
                            val arguments = it.toRoute<CatDetailRoute>()
                            CatDetailScreen(
                                cat = arguments.cat,
                                breedSize = arguments.breedSize,
                            )
                        }
                    }
                }
            }
        }
    }
}