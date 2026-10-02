package com.elevadormidia.player.ui.player

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.tween
import com.elevadormidia.player.model.MediaItem
import com.elevadormidia.player.model.MediaType
import kotlinx.coroutines.delay

@Composable
fun PlayerScreen() {

    val medias = remember {
        listOf(
            MediaItem(id = 1, title = "Propaganda 01", type = MediaType.IMAGE, durationMs = 5000),
            MediaItem(id = 2, title = "Propaganda 02", type = MediaType.IMAGE, durationMs = 5000),
            MediaItem(id = 3, title = "Propaganda 03", type = MediaType.IMAGE, durationMs = 5000)
        )
    }

    val pagerState = rememberPagerState(pageCount = { medias.size })

    LaunchedEffect(Unit) {
        while (true) {
            val paginaAtual = pagerState.currentPage
            val mediaAtual = medias[paginaAtual]
            delay(mediaAtual.durationMs)
            val proximaPagina = (paginaAtual + 1) % medias.size
            pagerState.animateScrollToPage(page = proximaPagina,animationSpec = tween(durationMillis = 600))
        }
    }

    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize(), userScrollEnabled = false) { pagina ->
        val media = medias[pagina]
        val corFundo = when (pagina) {
            0 -> Color(0xFF1565C0)
            1 -> Color(0xFF2E7D32)
            else -> Color(0xFFC62828)
        }
        Box(modifier = Modifier.fillMaxSize().background(corFundo), contentAlignment = Alignment.Center) {
            Text(text = media.title, color = Color.White, fontSize = 40.sp)
        }
    }
}