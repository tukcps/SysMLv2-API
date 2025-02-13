@file:Suppress("unused")

package com.github.tukcps.sysmlv2.entities.requestModels

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.tukcps.sysmlv2.entities.ElementDAO
import com.github.tukcps.sysmlv2.entities.Identified
import java.util.*


/**
 * The payload model for a request of a client to a SysML v2 server.
 * The value of _type_ is mandatory.
 * All other fields are optional, depending on the type.
 */
class ElementRequest(): ElementDAO {
    @JsonProperty("@id")
    var id: UUID = UUID.randomUUID() // elementId?

    @JsonProperty("@type")
    override var type: String = ""

    // The following are required for every Element
    override var name: String? = null
    override var shortName: String? = null
    override var declaredShortName: String? = null
    override var declaredName: String? = null
    override var ownedElements: MutableList<Identified> = mutableListOf() // The IDs of the owned elements.
    override var owner: Identified? = null                 // The ID of the owner; if null, the node is the root of an ownership tree

    // For type Feature :
    override var direction: String? = null

    override var importedMemberName: String? = null
    override var importedNamespace: String? = null

    // For type AnnotationElement and subclasses
    override var language: String? = null   // language, e.g. SysMD, SysML
    override var body: String? = null       // The code in e.g. SysMD or SysML v2 textual

    // For Relationship and subtypes thereof:
    override var source: MutableList<Identified>? = null     // qualified names of sources
    override var target: MutableList<Identified>? = null     // qualified names of targets

    @JsonProperty("isLibraryElement")
    override var isLibraryElement: Boolean? = false
    @JsonProperty("isAbstract")
    override var isAbstract: Boolean? = null
    @JsonProperty("isSufficient")
    override var isSufficient: Boolean? = null
    @JsonProperty("isConjugated")
    override var isConjugated: Boolean? = null
    @JsonProperty("isUnique")
    override var isUnique: Boolean? = null
    @JsonProperty("isOrdered")
    override var isOrdered: Boolean? = null
    @JsonProperty("isComposite")
    override var isComposite: Boolean? = null
    @JsonProperty("isEnd")
    override var isEnd: Boolean? = null
    @JsonProperty("isDerived")
    override var isDerived: Boolean? = null
    @JsonProperty("isReadOnly")
    override var isReadOnly: Boolean? = null

    @JsonProperty("isStandard")
    override var isStandard: Boolean? = false
    @JsonProperty("isImplied")
    override var isImplied: Boolean? = null
    @JsonProperty("isImpliedIncluded")
    override var isImpliedIncluded: Boolean? = null

    override var elementId: UUID
        get() = id
        set(value) { id = value }

    override var aliasIds: MutableList<String> = mutableListOf()
    override var owningMembership: Identified? = null
    override var owningNamespace: Identified? = null
    override var owningRelationship: Identified? = null
    override var documentation: Identified? = null
    override var textualRepresentation: MutableList<Identified>? = null

    constructor(element: ElementDAO): this() {
        copyFrom(element)
    }
}
