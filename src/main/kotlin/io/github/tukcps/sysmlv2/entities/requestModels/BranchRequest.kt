@file:Suppress("unused", "CanBePrimaryConstructorProperty")
package io.github.tukcps.sysmlv2.entities.requestModels

import com.fasterxml.jackson.annotation.JsonIncludeProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.tukcps.sysmlv2.entities.Identified

class BranchRequest(
    type: String = "Branch",
    @JsonIncludeProperties("@id")
    var head: Identified? = null,
    var name: String? = null
) {
    @JsonProperty("@type")
    var type: String = type
}