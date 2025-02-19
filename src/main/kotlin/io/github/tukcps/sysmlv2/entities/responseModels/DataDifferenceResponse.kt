@file:Suppress("unused")
package io.github.tukcps.sysmlv2.entities.responseModels

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.tukcps.sysmlv2.entities.requestModels.DataVersionRequest

class DataDifferenceResponse(
    val baseData: DataVersionRequest?,
    val compareData: DataVersionRequest?
) {
    @JsonProperty("@type")
    val type: String = "DataDifference"
}