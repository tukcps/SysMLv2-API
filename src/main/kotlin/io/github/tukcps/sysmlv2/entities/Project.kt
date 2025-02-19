@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package io.github.tukcps.sysmlv2.entities

import java.util.*


/**
 *  Basic interface of a Project.
 *  The SysML v2 fields that are no basic types or where there are potential
 *  differences in request, response, persistence models are modeled as
 *  functions to avoid problems with serialization.
 */
interface Project: Record, ProjectBase {
    var created: Date
    fun defaultBranchId(): UUID?
    fun branchesIdList(): Collection<UUID>
    fun commitsIdList(): Collection<UUID>
    fun headsIdList(): List<UUID>
}