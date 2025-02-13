@file:Suppress("unused")
package com.github.tukcps.sysmlv2.entities

import java.util.*


interface Commit: Record {
    var owningProject: UUID?
    var created: Date
    var modified: Date?

    fun payloadIdList(): List<UUID>
    fun previousCommitIdList(): List<UUID>
}