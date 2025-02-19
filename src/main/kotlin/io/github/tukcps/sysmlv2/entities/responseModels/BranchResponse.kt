@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package io.github.tukcps.sysmlv2.entities.responseModels

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.tukcps.sysmlv2.entities.Branch
import io.github.tukcps.sysmlv2.entities.Identified
import io.github.tukcps.sysmlv2.entities.Identity
import java.util.*

/**
 * @author: Amartya Parijat
 * Response Model for Branches
 */
class BranchResponse(
    id: UUID = UUID.randomUUID(),
    type: String = RESPONSE_TYPE,
    var created: Date? = null,
    var referencedCommit: Identified? = null,
    var owningProject: Identified? = null,
    var head: Identified? = null,
    var name: String? = null,
): Identity(id) {
    @Suppress("CanBePrimaryConstructorProperty")
    @JsonProperty("@type")
    val type: String = type

    constructor(branch: io.github.tukcps.sysmlv2.entities.Branch): this(
        id = branch.id,
        created = branch.created,
        head = branch.referencedCommitId()?.let { Identified(id = it) },
        referencedCommit = branch.referencedCommitId()?.let { Identified(id = it) },
        owningProject = branch.owningProjectId()?.let { Identified(id = it) },
        name = branch.name
    )

    companion object {
        const val RESPONSE_TYPE: String = "Branch"
    }
}