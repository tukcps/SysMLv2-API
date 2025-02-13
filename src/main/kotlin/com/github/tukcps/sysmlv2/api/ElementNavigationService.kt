@file:Suppress("unused")
package com.github.tukcps.sysmlv2.api

import com.github.tukcps.sysmlv2.entities.ElementDAO
import java.util.*

interface ElementNavigationService {

    /**
     * Gets all elements of the default branch heda of a project by name.
     * The name has the format "[project:]path/filename[:versionNr]
     * @param projectName a string that uniquely identifies a revision.
     */
    fun getElements(projectName: String): Collection<ElementDAO>

    /**
     * Gets all elements of a project by project and commit id.
     */
    fun getElements(projectId: UUID, commitId: UUID?): Collection<ElementDAO>
    fun getElementById(projectId: UUID, commitId: UUID, elementId: UUID): ElementDAO?
    fun getRelationshipsByRelatedElement(projectId: UUID, commitId: UUID, relatedElementId: UUID, direction: String): Collection<ElementDAO>
    fun getRootElements(projectId: UUID, commitId: UUID?): Collection<ElementDAO>
}