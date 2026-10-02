package com.elevadormidia.player.model

data class MediaItem(
    val id: Int,
    val title: String,
    val type: MediaType,
    val durationMs: Long
)