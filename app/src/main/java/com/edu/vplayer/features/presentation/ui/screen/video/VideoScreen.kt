package com.edu.vplayer.features.presentation.ui.screen.video

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun VideoViewScreen(navController: NavHostController) {
    val context = LocalContext.current
    val url = "https://ivy-videos.advancedpedagogy.com/videos/6256a4e9280d810012461500/hls/6256a4e9280d810012461500.m3u8?Key-Pair-Id=K2LBSI333XICIR&Policy=eyJTdGF0ZW1lbnQiOlt7IlJlc291cmNlIjoiaHR0cHM6Ly9pdnktdmlkZW9zLmFkdmFuY2VkcGVkYWdvZ3kuY29tL3ZpZGVvcy82MjU2YTRlOTI4MGQ4MTAwMTI0NjE1MDAvaGxzLyoiLCJDb25kaXRpb24iOnsiRGF0ZUxlc3NUaGFuIjp7IkFXUzpFcG9jaFRpbWUiOjE2OTU4MDM3MjR9fX1dfQ__&Signature=o-2RDh5quTM6lBw9zjh3josdzcseEl1c-3icczPEwIl4ggjvjtJiEdFClmfdgS7Zp2f8ni3~7gew~yZ7qpZbsxy5nX7XJETCDWZdVpTcVI~5OJfUVeeCScEfDQdm-diwcg354BG83JKXhpA16jVW04wgZt8unn0n~MXex2pedo1VZjUJoK-MudDm7bF1V2jyXGJ4B0-tVlpfAlRXdYbJRD~hBQfwwxMJ~FWUrNLCA3zi8P9v4y2rmvrMLcpar9nE58qjjJYNSURmEzCT8x5auk-2OjIAeEwTTBBKqz5K1d-vU~JMW8ZmSCu1C0LzNEEl~758XBhH38y7SD~PWT~L7Q__&Signed-Query-String=S2V5LVBhaXItSWQ9SzJMQlNJMzMzWElDSVImUG9saWN5PWV5SlRkR0YwWlcxbGJuUWlPbHQ3SWxKbGMyOTFjbU5sSWpvaWFIUjBjSE02THk5cGRua3RkbWxrWlc5ekxtRmtkbUZ1WTJWa2NHVmtZV2R2WjNrdVkyOXRMM1pwWkdWdmN5ODJNalUyWVRSbE9USTRNR1E0TVRBd01USTBOakUxTURBdmFHeHpMeW9pTENKRGIyNWthWFJwYjI0aU9uc2lSR0YwWlV4bGMzTlVhR0Z1SWpwN0lrRlhVenBGY0c5amFGUnBiV1VpT2pFMk9UVTRNRE0zTWpSOWZYMWRmUV9fJlNpZ25hdHVyZT1vLTJSRGg1cXVUTTZsQnc5empoM2pvc2R6Y3NlRWwxYy0zaWNjelBFd0lsNGdnanZqdEppRWRGQ2xtZmRnUzdacDJmOG5pM343Z2V3fnlaN3FwWmJzeHk1blg3WEpFVENEV1pkVnBUY1ZJfjVPSmZVVmVlQ1NjRWZEUWRtLWRpd2NnMzU0Qkc4M0pLWGhwQTE2alZXMDR3Z1p0OHVubjBufk1YZXgycGVkbzFWWmpVSm9LLU11ZERtN2JGMVYyanlYR0o0QjAtdFZscGZBbFJYZFliSlJEfmhCUWZ3d3hNSn5GV1VyTkxDQTN6aThQOXY0eTJybXZyTUxjcGFyOW5FNThxampKWU5TVVJtRXpDVDh4NWF1ay0yT2pJQWVFd1RUQkJLcXo1SzFkLXZVfkpNVzhabVNDdTFDMEx6TkVFbH43NThYQmhIMzh5N1NEflBXVH5MN1FfXw=="
    val exoPlayer = ExoPlayer.Builder(context).build()
    val mediaItem = MediaItem.fromUri(Uri.parse(url))
    exoPlayer.setMediaItem(mediaItem)
    val playerView = StyledPlayerView(context)

    playerView.player = exoPlayer

    DisposableEffect(
        AndroidView(factory = {playerView})

    ){
        exoPlayer.prepare()
        exoPlayer.playWhenReady= true

        onDispose {
            exoPlayer.release()
        }
    }

}