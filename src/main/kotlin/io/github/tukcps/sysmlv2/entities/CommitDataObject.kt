@file:Suppress("unused")
package io.github.tukcps.sysmlv2.entities

import java.util.*

interface CommitDataObject {
    var id: UUID
    var type: io.github.tukcps.sysmlv2.entities.CommitDataObject.DataVersionType

    var payloadElementSnapshot: io.github.tukcps.sysmlv2.entities.ElementDAO? // not in standard; allows us faster operation
    var element: io.github.tukcps.sysmlv2.entities.ElementDAO?
    var projectUsage: io.github.tukcps.sysmlv2.entities.ProjectUsage?
    /**
     * In a commit, we distinguish four cases:
     * - Change of an element
     * - Change of a relationship,
     * - Deleting an element from a commit,
     * - Project usage = reference to another project to be added to session.
     */
    enum class DataVersionType {
        ChangedElement, ChangedRelationship, DeletedInCommit, ProjectUsage
    }
}