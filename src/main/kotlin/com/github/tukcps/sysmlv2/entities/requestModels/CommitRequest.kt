@file:Suppress("unused", "CanBePrimaryConstructorProperty")
package com.github.tukcps.sysmlv2.entities.requestModels

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Request model for commits:
 * - name
 * - description
 * - id of the previous commit or null, if no previous commit.
 */
class CommitRequest(
    type: String = RESPONSE_TYPE,
    var description: String? = null,
    var change: List<DataVersionRequest> = ArrayList()
) {
    @JsonProperty("@type")
    var type: String = type

    companion object {
        const val RESPONSE_TYPE: String = "Commit"
    }
}