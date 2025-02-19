@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package io.github.tukcps.sysmlv2.entities.responseModels

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.tukcps.sysmlv2.entities.Identified
import io.github.tukcps.sysmlv2.entities.Identity
import io.github.tukcps.sysmlv2.entities.Project
import java.util.*

/**
 * The Project response.
 */
class ProjectResponse(
    id: UUID = UUID.randomUUID(),
    type: String = RESPONSE_TYPE,
    val name: String? = null,
    var description: String? = null,
    var defaultBranch: Identified? = null,
    var created: Date? = null
): Identity(id) {
    @Suppress("CanBePrimaryConstructorProperty")
    @JsonProperty("@type")
    val type: String = type

    constructor(project: Project): this(
        id = project.id,
        name = project.name,
        defaultBranch = project.defaultBranchId()?.let { Identified(id = it) },
        description = project.description,
        created = project.created
    )

    companion object {
        const val RESPONSE_TYPE: String = "Project"
    }
}