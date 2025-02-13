@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.github.tukcps.sysmlv2.entities.responseModels

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.tukcps.sysmlv2.entities.Commit
import com.github.tukcps.sysmlv2.entities.Identified
import com.github.tukcps.sysmlv2.entities.Identity
import java.util.*

/**
 * Used only for the REST response of a Commit class.
 * Change since 2.8:
 * - Payload removed; get the payload via the Get Elements request.
 */
class CommitResponse(
    @JsonProperty("@id")
    id: UUID = UUID.randomUUID(),                 // id, always there.
    @JsonProperty("@type")
    var type: String = RESPONSE_TYPE,
    @JsonProperty("description")
    var description: String? = null,    // description text of the commit, optional
    @JsonProperty("previousCommit")
    var previousCommit: List<Identified>? = ArrayList(), // Previous commit, optional
    @JsonProperty("owningProject")
    var owningProject: Identified? = null,
    @JsonProperty("created")
    var created: Date? = null
): Identity(id) {



    /**
     * Builds a response entity from a real Commit
     */
    constructor(commit: Commit): this(
        id = commit.id,
        description = commit.description,
        owningProject = Identified(id = commit.owningProject),
        created = commit.created,
        previousCommit = commit.previousCommitIdList().let { list -> list.map{(Identified(id = it))} }
    )

    companion object {
        const val RESPONSE_TYPE: String = "Commit"
    }
}
