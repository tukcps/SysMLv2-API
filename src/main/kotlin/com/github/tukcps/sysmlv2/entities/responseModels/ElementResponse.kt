@file:Suppress("unused", "CanBePrimaryConstructorProperty")

package com.github.tukcps.sysmlv2.entities.responseModels

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.tukcps.sysmlv2.entities.ElementDAO
import com.github.tukcps.sysmlv2.entities.Identified
import java.util.*

/**
 * Use this class for serialization of the Element Response with Jackson
 */
class ElementResponse(
    id: UUID,
    type: String,
    override var name: String? = null,
    override var shortName: String? = null,
    override var declaredName: String? = null,
    override var declaredShortName: String? = null,
    override var ownedElements: MutableList<Identified> = mutableListOf(),     // The IDs of the owned elements.
    override var owner: Identified? = null,
    override var owningMembership: Identified? = null,
    override var owningNamespace: Identified? = null,
    override var owningRelationship: Identified? = null,

    // For type = Feature
    override var direction: String? = null,

    // For type = Import
    override var importedMemberName: String? = null,
    override var importedNamespace: String? = null,

    // For type = AnnotationElement
    override var language: String? = null,                       // Language, e.g. SysML, SysMD, ...
    override var body: String? = null,                           // Documentation

    // For type = Relationship and subtypes thereof
    override var source: MutableList<Identified>? = null,
    override var target: MutableList<Identified>? = null,
    isStandard: Boolean? = null,
    isLibraryElement: Boolean = false,
    isImplied: Boolean? = null,
    isImpliedIncluded: Boolean? = null,
    override var documentation: Identified? = null,
    override var textualRepresentation: MutableList<Identified>? = null,
    override var isAbstract: Boolean? = null,
    override var isSufficient: Boolean? = null,
    override var isConjugated: Boolean? = null,
    override var isUnique: Boolean? = null,
    override var isOrdered: Boolean? = null,
    override var isComposite: Boolean? = null,
    override var isEnd: Boolean? = null,
    override var isDerived: Boolean? = null,
    override var isReadOnly: Boolean? = null,
): ElementDAO {
    @JsonProperty("@id")
    var id: UUID = id
    override var elementId: UUID
        get() = id
        set(value) { id = value }
    override var aliasIds: MutableList<String> = mutableListOf()

    @JsonProperty("@type")
    override var type: String = type
    @get:JsonProperty("isStandard")
    override var isStandard: Boolean? = isStandard
    @get:JsonProperty("isLibraryElement")
    override var isLibraryElement: Boolean? = isLibraryElement
    @get:JsonProperty("isImplied")
    override var isImplied: Boolean? = isImplied
    @get:JsonProperty("isImpliedIncluded")
    override var isImpliedIncluded: Boolean? = isImpliedIncluded

    @Deprecated("Not Used anymore only there for Compatibility")
    @JsonIgnore
    var valueStr:String? = null

    constructor(element: ElementDAO): this(id = element.elementId, type = element.type) {
        copyFrom(element)
    }
    private constructor(): this(id=UUID.randomUUID(), type="Element")
}
