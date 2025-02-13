@file:Suppress("unused")

package com.github.tukcps.sysmlv2.api

import com.github.tukcps.sysmlv2.entities.Project
import java.util.*


/**
 * SysML v2 API platform independent project services
 */
interface ProjectService {
    fun createProject(project: Project): Project
    fun getProjects(): List<Project>
    fun getProjectById(id: UUID): Project?
    fun getProjectByName(projectName: String): Project?
    fun updateProject(project: Project)
    fun deleteProject(id: UUID): Boolean
}