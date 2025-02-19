@file:Suppress("unused")
package io.github.tukcps.sysmlv2.entities.responseModels

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.tukcps.sysmlv2.entities.ElementDAO
import io.github.tukcps.sysmlv2.entities.Identified
import java.util.*

class RelationshipResponse(
    id: UUID,
    type: String,
    override var aliasIds: MutableList<String> = mutableListOf(),
    override var name: String? = null,
    override var shortName: String? = null,
    override var documentation: Identified? = null,
    val effectiveName: String? = null,
    isImplied: Boolean? = null,
    isImpliedIncluded: Boolean? = null,
    override var owner: Identified? = null,
    val ownedElement: List<Identified> = mutableListOf(),
    val ownedAnnotation: List<Identified> = mutableListOf(),
    val ownedRelatedElement: List<Identified> = mutableListOf(),
    val ownedRelationship: List<Identified> = mutableListOf(),
    override var owningMembership: Identified? = null,
    override var owningNamespace: Identified? = null,
    val qualifiedName: String? = null,
    val relatedElement: List<Identified>? = null,
    override var source: MutableList<Identified>? = mutableListOf(), // Id
    override var target: MutableList<Identified>? = mutableListOf(), // Id
    override var textualRepresentation: MutableList<Identified>? = null,
    override var declaredName: String? = null,
    override var declaredShortName: String? = null,
    override var ownedElements: MutableList<Identified> = mutableListOf(),
    override var owningRelationship: Identified? = null,
    override var isAbstract: Boolean? = null,
    override var isSufficient: Boolean? = null,
    override var isConjugated: Boolean? = null,
    override var isUnique: Boolean? = null,
    override var isOrdered: Boolean? = null,
    override var isComposite: Boolean? = null,
    override var isEnd: Boolean? = null,
    override var isDerived: Boolean? = null,
    override var isReadOnly: Boolean? = null
): io.github.tukcps.sysmlv2.entities.ElementDAO {
    @JsonProperty("@id")
    var id: UUID = id
    override var elementId: UUID
        get() = id
        set(value) { id = value }

    @JsonProperty("@type")
    override var type: String = type
    override var direction: String?
        get() = null
        set(value) {}
    override var importedMemberName: String?
        get() = null
        set(value) {}
    override var importedNamespace: String?
        get() = null
        set(value) {}
    override var language: String?
        get() = null
        set(value) {}
    override var body: String?
        get() = null
        set(value) {}

    @JsonProperty("isStandard")
    override var isStandard: Boolean? = null
    @JsonProperty("isLibraryElement")
    override var isLibraryElement: Boolean? = null
    @JsonProperty("isImplied")
    override var isImplied: Boolean? = isImplied
    @JsonProperty("isImpliedIncluded")
    override var isImpliedIncluded: Boolean? = isImpliedIncluded

    constructor(element: io.github.tukcps.sysmlv2.entities.ElementDAO): this(id=element.elementId, type=element.type) {
        copyFrom(element)
    }
}
