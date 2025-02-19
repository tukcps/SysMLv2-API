@file:Suppress("unused")
package io.github.tukcps.sysmlv2.entities

import java.util.*


interface Commit: io.github.tukcps.sysmlv2.entities.Record {
    var owningProject: UUID?
    var created: Date
    var modified: Date?

    fun payloadIdList(): List<UUID>
    fun previousCommitIdList(): List<UUID>
}