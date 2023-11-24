package com.acasloa946.p4recycledview.Screens

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acasloa946.p4recycledview.R

data class Superhero(val superHeroName:String,val realName:String,val publisher:String, @DrawableRes var photo:Int) {



}
fun getSuperheroes():List<Superhero> {
    val myList = listOf<Superhero>(Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)
    )
    return myList
}

/*
@Composable
fun SuperheroView() {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val listaSuperheroes = getSuperheroes()
        items(listaSuperheroes) {
            val context = LocalContext.current
            ItemHero(superHero = it,
                onClickCard = {
                    Toast.makeText(context,it.realName,Toast.LENGTH_SHORT).show()
               })
        }
    }
}

 */

@Composable
fun SuperheroView() {
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        val listaSuperheroes = getSuperheroes()
        items(listaSuperheroes) {
            val context = LocalContext.current
            ItemHero(superHero = it,
                onClickCard = {
                    Toast.makeText(context,it.realName,Toast.LENGTH_SHORT).show()
                })
        }
    })



}

@Composable
fun ItemHero(
    superHero:Superhero,
    onClickCard : (Superhero) -> Unit
    ) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onClickCard(superHero) },
        border = BorderStroke(2.dp, Color.Red)


    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            Image(painter = painterResource(id = superHero.photo), contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Text(text = superHero.superHeroName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Text(text = superHero.realName,
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 10.dp))
        }
    }
}


