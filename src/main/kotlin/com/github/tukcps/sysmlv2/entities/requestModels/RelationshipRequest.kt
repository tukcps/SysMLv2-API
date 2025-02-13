package com.github.tukcps.sysmlv2.entities.requestModels

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*


/**
 * Entity via which a Relationship element is requested.
 */
class RelationshipRequest(
    val elementId: UUID,
    val name: String?,
    val shortName: String?,

    @JsonProperty("@type")
    val type: String = "Relationship",

    val source: List<UUID>,     // qualified names of source
    val target: List<UUID>,     // qualified names of target
)
