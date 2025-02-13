@file:Suppress("unused")

package com.github.tukcps.sysmlv2.entities


import java.util.Date
import java.util.UUID

interface Branch: CommitReference {
    var created: Date?
    var modified: Date?
    fun owningProjectId(): UUID?
}