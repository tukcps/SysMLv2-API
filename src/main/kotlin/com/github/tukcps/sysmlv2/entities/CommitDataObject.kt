@file:Suppress("unused")
package com.github.tukcps.sysmlv2.entities

import java.util.*

interface CommitDataObject {
    var id: UUID
    var type: DataVersionType

    var payloadElementSnapshot: ElementDAO? // not in standard; allows us faster operation
    var element: ElementDAO?
    var projectUsage: ProjectUsage?
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