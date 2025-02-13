package com.github.tukcps.sysmlv2.entities.requestModels.commitData

import com.fasterxml.jackson.annotation.JsonTypeName
import com.github.tukcps.sysmlv2.entities.Identified
import org.intellij.lang.annotations.Language
import java.util.*

@JsonTypeName(CommitType.ELEMENT)
class ElementCommitData(
    id: UUID,
    type: String,       // mandatory type of the metamodel as annotation
    aliasIds: List<String> = ArrayList(),
    declaredName: String? = null,
    declaredShortName: String? = null,
    documentation: Identified? = null,
    elementId: String? = null,
    isImpliedIncluded: Boolean? = null,
    isLibraryElement: Boolean? = null,
    name: String? = null,
    ownedAnnotation: List<Identified> = ArrayList(),
    ownedElement: List<Identified> = ArrayList(),
    ownedRelationship: List<Identified> = ArrayList(),
    owner: Identified? = null,
    owningMembership: Identified? = null,
    owningNamespace: Identified? = null,
    owningRelationship: Identified? = null,
    qualifiedName: String? = null,
    language: String? = null,
    shortName: String? = null,
    textualRepresentation: List<Identified> = ArrayList()
): CommitData(
    id = id,
    type = type,
    aliasIds = aliasIds,
    declaredName = declaredName,
    declaredShortName = declaredShortName,
    documentation = documentation,
    elementId = elementId,
    isImpliedIncluded = isImpliedIncluded,
    isLibraryElement = isLibraryElement,
    name= name,
    ownedAnnotation = ownedAnnotation,
    ownedElement = ownedElement,
    ownedRelationship = ownedRelationship,
    owner = owner,
    owningMembership = owningMembership,
    owningNamespace = owningNamespace,
    owningRelationship = owningRelationship,
    qualifiedName = qualifiedName,
    shortName = shortName,
    language = language,
    textualRepresentation = textualRepresentation
)