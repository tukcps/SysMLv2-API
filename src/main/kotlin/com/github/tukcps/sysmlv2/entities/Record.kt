package com.github.tukcps.sysmlv2.entities

import java.net.URI
import java.util.*


/**
 * Abstract baseclass that represents any data that is consumed or produced by the Backend API.
 */
interface Record {
    var id: UUID
    var alias: List<String>         // includes name at least
    var name: String                // Unique, --> humanIdentifier
    var description: String
    fun resourceIdentifier(): URI? = null
}