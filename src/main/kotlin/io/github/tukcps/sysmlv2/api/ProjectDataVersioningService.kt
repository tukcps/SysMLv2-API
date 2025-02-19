@file:Suppress("unused")

package io.github.tukcps.sysmlv2.api

import io.github.tukcps.sysmlv2.entities.*
import java.util.*


interface ProjectDataVersioningService {

    fun getCommits(projectId: UUID): Collection<io.github.tukcps.sysmlv2.entities.Commit>

    /**
     * Gets head of a commit of a project branch, or default branch if no branch is given
     */
    fun getHeadCommit(projectId: UUID, branchId: UUID?): io.github.tukcps.sysmlv2.entities.Commit

    /**
     * Gets a commit by its id
     */
    fun getCommitById(projectId: UUID, commitId: UUID?): io.github.tukcps.sysmlv2.entities.Commit
    fun createCommit(projectId: UUID, commit: io.github.tukcps.sysmlv2.entities.Commit): io.github.tukcps.sysmlv2.entities.Commit
    fun getCommitChange()
    fun getCommitChangeById()
    fun getBranches(projectId: UUID): Collection<io.github.tukcps.sysmlv2.entities.Branch>
    fun getBranchById(projectId: UUID, branchId: UUID?): io.github.tukcps.sysmlv2.entities.Branch
    fun getDefaultBranch(projectId: UUID): UUID
    fun setDefaultBranch(projectId: UUID, branchID: UUID)
    fun createBranch(projectId: UUID, branch: io.github.tukcps.sysmlv2.entities.Branch)
    fun deleteBranch(projectId: UUID, branchId: UUID): Boolean
    fun getTags(projectId: UUID): Collection<Tag>
    fun getTagById(projectId: UUID, tagId: UUID): Tag
    fun getExternalRelationships()

    /**
     * Writes all information from a commit into the repository, and returns an id of the commit.
     * When writing to the repository, the packages among the elements will be tagged with the revision tag that will also be returned in response.
     * @param name a user-given name
     * @param description a brief description of the commit
     * @param changes, the committed data, consisting of a data class CommitData with
     * - all elements defined in the commit,
     * - all properties defined in the commit
     * - all relations defined in the document
     * - globalUId of the root of decomposition
     * @param previousCommit the id of the previous version of the document
     * @return An id that uniquely identifies the commit
     */
    fun commit(
        owningProject: UUID,
        name: String?,
        description: String?,
        payload: List<io.github.tukcps.sysmlv2.entities.CommitDataObject>,
        previousCommit: UUID? = null): UUID
}