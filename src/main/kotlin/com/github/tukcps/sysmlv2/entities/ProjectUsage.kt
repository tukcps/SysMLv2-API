@file:Suppress("unused")
package com.github.tukcps.sysmlv2.entities

import java.util.*

interface ProjectUsage {
    var usedCommit: UUID
    var owningProject: UUID
}