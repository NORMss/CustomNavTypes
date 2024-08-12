package com.norm.mycustomnavtypes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CatListScreen(
    onCatClick: (Cat, BreedSize) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(SAMPLE_DATA_CATS.keys.toList()) { cat ->
            Text(
                text = cat.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onCatClick(
                            cat,
                            SAMPLE_DATA_CATS[cat]!!
                        )
                    }
                    .padding(16.dp)
            )
        }
    }
}

val SAMPLE_DATA_CATS = mapOf(
    Cat(1, "Siamese") to BreedSize.MEDIUM,
    Cat(2, "Persian") to BreedSize.MEDIUM,
    Cat(3, "Maine Coon") to BreedSize.LARGE,
    Cat(4, "Bengal") to BreedSize.MEDIUM,
    Cat(5, "Sphynx") to BreedSize.MEDIUM,
    Cat(6, "British Shorthair") to BreedSize.MEDIUM,
    Cat(7, "Russian Blue") to BreedSize.MEDIUM,
    Cat(8, "Ragdoll") to BreedSize.LARGE,
    Cat(9, "Scottish Fold") to BreedSize.MEDIUM,
    Cat(10, "Abyssinian") to BreedSize.SMALL,
    Cat(11, "Norwegian Forest") to BreedSize.LARGE,
    Cat(12, "Oriental Shorthair") to BreedSize.SMALL,
    Cat(13, "Savannah") to BreedSize.LARGE,
    Cat(14, "Siberian") to BreedSize.LARGE,
    Cat(15, "Devon Rex") to BreedSize.SMALL,
    Cat(16, "Birman") to BreedSize.MEDIUM,
    Cat(17, "Cornish Rex") to BreedSize.SMALL,
    Cat(18, "Turkish Van") to BreedSize.MEDIUM,
    Cat(19, "Egyptian Mau") to BreedSize.SMALL,
    Cat(20, "Balinese") to BreedSize.SMALL
)