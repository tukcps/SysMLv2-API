@file:Suppress("unused")
package com.github.tukcps.sysmlv2.entities

import java.util.UUID

interface CommitReference : Record {
    fun referencedCommitId(): UUID?
}