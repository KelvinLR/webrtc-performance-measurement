package io.getstream.webrtc.sample.compose.webrtc.metrics

import android.os.Handler
import android.os.Looper
import org.webrtc.PeerConnection

class WebRTCStatsCollector(
  private val peerConnection: PeerConnection,
  private val onStatsReady: (WebRTCStatsDTO) -> Unit
) {

  private val handler = Handler(Looper.getMainLooper())

  fun start() {
    handler.postDelayed(object : Runnable {
      override fun run() {
        peerConnection.getStats { report ->
          val stats = WebRTCStatsExtractor.extract(report)
          onStatsReady(stats)
        }
        handler.postDelayed(this, 1000)
      }
    }, 1000)
  }

  fun stop() {
    handler.removeCallbacksAndMessages(null)
  }
}