package io.github.tukcps.sysmlv2.entities

import java.net.URL

open class InterchangeProjectUsage(
    open var resource: URL,
    open var versionConstraint: String? = null
)