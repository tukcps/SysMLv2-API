@file:Suppress("MemberVisibilityCanBePrivate")

package io.github.tukcps.sysmlv2.entities.responseModels

import java.time.ZonedDateTime
import java.util.Date


open class FileVersionResponse(
    var name: String,
    var url: String,
    var type: String,
    var size: Long,
    var id: String,
    var version: Long,
    var created: Date? ,
    var modified: Date?
){

    // Just for Jackson deserialization ... constructor without parameters.
    private constructor(): this(name="", url="", type="",0, id="", version=0,created=Date.from(ZonedDateTime.now().toInstant()),modified=Date.from(ZonedDateTime.now().toInstant()))
}