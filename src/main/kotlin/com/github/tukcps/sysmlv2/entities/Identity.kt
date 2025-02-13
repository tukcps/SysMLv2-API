package com.github.tukcps.sysmlv2.entities

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

open class Identity(
    id: UUID? = null,
) {
    @JsonProperty("@id")
    var id: UUID? = id
}