@file:Suppress("unused")
package io.github.tukcps.sysmlv2.entities

import java.util.UUID

interface CommitReference : io.github.tukcps.sysmlv2.entities.Record {
    fun referencedCommitId(): UUID?
}