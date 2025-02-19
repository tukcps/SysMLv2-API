@file:Suppress("unused")
package io.github.tukcps.sysmlv2.entities

import java.util.*

interface ProjectUsage {
    var usedCommit: UUID
    var owningProject: UUID
}