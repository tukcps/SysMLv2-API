package io.github.tukcps.sysmlv2.entities.requestModels

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.tukcps.sysmlv2.entities.Identified
import io.github.tukcps.sysmlv2.entities.requestModels.commitData.CommitData
import java.util.*

class DataVersionRequest(
    id: UUID? = null,
    type: String = RESPONSE_TYPE,
    identity: DataIdentityRequest? = null,
    val payload: CommitData? = null,
): Identified(id) {
    @JsonProperty("@type")
    var type: String = type
    var identity: DataIdentityRequest? = identity

    companion object {
        const val RESPONSE_TYPE: String = "DataVersion"
    }
}

class DataIdentityRequest(
    id: UUID,
    type: String = RESPONSE_TYPE
): Identified(id) {
    @JsonProperty("@type")
    var type: String = type

    companion object {
        const val RESPONSE_TYPE: String = "DataIdentity"
    }
}
