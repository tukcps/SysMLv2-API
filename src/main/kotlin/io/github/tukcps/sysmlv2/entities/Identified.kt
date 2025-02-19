package io.github.tukcps.sysmlv2.entities

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

open class Identified(
    id: UUID? = null,
): Cloneable {
    @Suppress("CanBePrimaryConstructorProperty")
    @JsonProperty("@id")
    open var id: UUID? = id
    public override fun clone(): Identified = Identified(id)
}

/**
 * A function to clone a list
 */
fun <T: Identified> List<T>.clone(): MutableList<T> {
    val result = mutableListOf<T>()
    this.forEach { identity ->
        @Suppress("UNCHECKED_CAST")
        result.add(identity.clone() as T)
    }
    return result
}
