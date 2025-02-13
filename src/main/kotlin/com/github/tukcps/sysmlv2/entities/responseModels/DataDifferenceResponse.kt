@file:Suppress("unused")
package com.github.tukcps.sysmlv2.entities.responseModels

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.tukcps.sysmlv2.entities.requestModels.DataVersionRequest

class DataDifferenceResponse(
    val baseData: DataVersionRequest?,
    val compareData: DataVersionRequest?
) {
    @JsonProperty("@type")
    val type: String = "DataDifference"
}