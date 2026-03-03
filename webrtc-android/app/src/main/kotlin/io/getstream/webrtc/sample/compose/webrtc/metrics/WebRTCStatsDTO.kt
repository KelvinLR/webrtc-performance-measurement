package io.getstream.webrtc.sample.compose.webrtc.metrics

data class WebRTCStatsDTO(
  val timestamp: Long,
  val jitter: Double?,
  val rtt: Double?,
  val packetLoss: Int?,
  val bitrateOut: Double?,
  val bitrateIn: Double?
)