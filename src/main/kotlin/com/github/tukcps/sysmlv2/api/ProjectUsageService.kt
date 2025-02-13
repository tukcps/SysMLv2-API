@file:Suppress("unused")

package com.github.tukcps.sysmlv2.api

import com.github.tukcps.sysmlv2.entities.ProjectUsage
import java.util.*

interface ProjectUsageService {
    fun getProjectUsage(projectId: UUID, commitId: UUID): Collection<ProjectUsage>
    fun getProjectUsage(projectName: String): Collection<ProjectUsage>
    fun deleteProjectUsage(projectId: UUID, commitId: UUID?): Boolean
}