package com.example.movieapp.widgets


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.bawp.movieapp.model.Movie
import com.bawp.movieapp.model.getMovies
import com.example.movieapp.R


@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = { }) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movie.id)
            },

        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Column() {
                    Log.d(
                        TAG,
                        "MovieRow: ${movie.images[0]} It will work ${movie.images[0].toString()}"
                    )
//                    Text(text = "jhdfjsdghfjsg")
                    AsyncImage(
                        model = movie.images[0],
                        contentDescription = "Movie Poster"
                    )


//                    Image(
//
//                        painter = rememberAsyncImagePainter("https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyOTYyMzUxNl5BMl5BanBnXkFtZTcwNTg0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg"),
//                        contentDescription = "Movie Poster"
//                    )

                }

//                Icon(
//                    imageVector = Icons.Default.AccountBox,
//                    contentDescription = "Movie Image"
//                )
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Director:${movie.title}",
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = "Release:${movie.year}",
                    style = MaterialTheme.typography.caption
                )
            }

        }
    }
}
