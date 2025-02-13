@file:Suppress("unused")
package com.github.tukcps.sysmlv2.entities.requestModels

import com.fasterxml.jackson.annotation.JsonAlias

class ProjectRequest (
    // @NotBlank(message = "Name is mandatory")
    val name: String,
    var description: String? = null,
    @JsonAlias("default")
    var defaultBranchName: String? = null,
)