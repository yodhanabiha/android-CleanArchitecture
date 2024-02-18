package com.nabiha.albumfeauture.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nabiha.entity.AlbumEntity

@Composable
fun AlbumCard(
    modifier: Modifier = Modifier,
    album: AlbumEntity
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = album.NamaAlbum, fontSize = 18.sp)
            Text(text = album.Deskripsi, fontSize = 14.sp)
            Text(text = album.TanggalDibuat, fontSize = 14.sp)
        }

    }

}