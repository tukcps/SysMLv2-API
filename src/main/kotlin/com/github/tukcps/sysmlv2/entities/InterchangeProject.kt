@file:Suppress("unused")

package com.github.tukcps.sysmlv2.entities

import java.net.URI
import java.util.*

interface ProjectBase {
    var id: UUID
    var name: String
    var description: String
}

/**
 * Interchange project file information following standard
 */
open class InterchangeProject(
    override var id: UUID = UUID.randomUUID(), // Non-standard, for UUID of commit
    override var name: String,
    override var description: String = "",
    open var version: String = "*",
    open var license: String? = null,
    open var maintainer: MutableList<String> = mutableListOf(),
    open var website: URI? = null,
    open var topic: MutableList<String> = mutableListOf()
): ProjectBase
