@file:Suppress("unused")

package io.github.tukcps.sysmlv2.entities


import java.util.Date
import java.util.UUID

interface Branch: io.github.tukcps.sysmlv2.entities.CommitReference {
    var created: Date?
    var modified: Date?
    fun owningProjectId(): UUID?
}