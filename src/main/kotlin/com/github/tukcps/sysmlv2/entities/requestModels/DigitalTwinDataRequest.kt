package com.github.tukcps.sysmlv2.entities.requestModels

import java.util.*

class DigitalTwinDataRequest(
//    identification:UUID? = null,
    var beginning: Date = Date(2000,1,1),
    var ending: Date = Date(2000,1,1)
) {
//    @JsonProperty("@id")
//    val id:UUID? = identification
}
