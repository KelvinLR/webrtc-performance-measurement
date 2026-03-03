package io.getstream.webrtc.sample.compose.webrtc.metrics

import android.util.Log

class WebRTCStatsSender {

  fun send(stats: WebRTCStatsDTO) {

    Log.d("WEBRTC_STATS", """
            -------- CALL METRICS --------
            Timestamp: ${stats.timestamp}
            RTT: ${stats.rtt} s
            Jitter: ${stats.jitter} s
            Packet Loss: ${stats.packetLoss}
            Bitrate Out: ${stats.bitrateOut}
            Bitrate In: ${stats.bitrateIn}
            --------------------------------
        """.trimIndent())
  }
}