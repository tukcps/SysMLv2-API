package io.github.tukcps.sysmlv2.entities.requestModels

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class DigitalTwinRequest (
    iden:UUID = UUID.randomUUID(),
    var name : String? = null,
    var branchId : UUID ? = null,
    var commitId : UUID,
    var connectedElements : MutableList<UUID> = mutableListOf()
) {
    @JsonProperty("@id")
    var id:UUID = iden
}
