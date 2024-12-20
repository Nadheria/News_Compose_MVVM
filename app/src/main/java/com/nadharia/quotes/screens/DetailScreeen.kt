package com.nadharia.quotes.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nadharia.quotes.ViewModels.DetailViewModel

@Composable
fun DetailScreen() {
    val detailViewModel:DetailViewModel = hiltViewModel()
    val tweets = detailViewModel.details.collectAsState()
    LazyColumn(content = {
        items(tweets.value){
            QuoteListItems(tweet = it.text)

        }
    })
}
@Composable
fun QuoteListItems(tweet:String) {

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(8.dp)
    ) {

        Row(Modifier.padding(16.dp)) {

            Image(
                imageVector = Icons.Default.FormatQuote,
                contentDescription = "Profile Icon",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black)
                    .rotate(180f),
                alignment = Alignment.TopStart,
                colorFilter = ColorFilter.tint(Color.White)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {


                Text(
                    text = tweet,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )

                Box(
                    modifier = Modifier
                        .background(Color(0xFFEEEEEE))
                        .fillMaxWidth(.4f)
                        .height(1.dp)

                )


            }
        }

    }

}
