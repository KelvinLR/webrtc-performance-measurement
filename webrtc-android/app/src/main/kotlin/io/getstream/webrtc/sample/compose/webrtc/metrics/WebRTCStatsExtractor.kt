package io.getstream.webrtc.sample.compose.webrtc.metrics

import org.webrtc.RTCStatsReport

object WebRTCStatsExtractor {

  fun extract(report: RTCStatsReport): WebRTCStatsDTO {

    var jitter: Double? = null
    var rtt: Double? = null
    var packetsLost: Int? = null
    var bitrateOut: Double? = null
    var bitrateIn: Double? = null

    report.statsMap.values.forEach { stat ->

      when (stat.type) {

        "candidate-pair" -> {

          if (stat.members["state"] == "succeeded") {
            rtt = stat.members["currentRoundTripTime"] as? Double
            bitrateOut =
              stat.members["availableOutgoingBitrate"] as? Double
            bitrateIn =
              stat.members["availableIncomingBitrate"] as? Double
          }
        }

        "inbound-rtp" -> {

          jitter = stat.members["jitter"] as? Double
          packetsLost = stat.members["packetsLost"] as? Int
        }

        "outbound-rtp" -> {

          bitrateOut =
            stat.members["bytesSent"] as? Double
        }
      }
    }

    return WebRTCStatsDTO(
      timestamp = System.currentTimeMillis(),
      jitter = jitter,
      rtt = rtt,
      packetLoss = packetsLost,
      bitrateOut = bitrateOut,
      bitrateIn = bitrateIn
    )
  }
}