package com.github.tukcps.sysmlv2.entities.requestModels.commitData

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.github.tukcps.sysmlv2.entities.Identified
import java.util.UUID

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type", visible = true)
@JsonSubTypes(
        JsonSubTypes.Type(
                value = ElementCommitData::class,
                names = [
                    CommitType.ELEMENT,
                    CommitType.PACKAGE,
                    CommitType.MEMBERSHIP_IMPORT,
                    CommitType.MULTIPLICITY,
                    CommitType.CLASSIFIER,
                    CommitType.CLASS,
                    CommitType.TYPE,
                    CommitType.FEATURE,
                    CommitType.NAMESPACE,
                    CommitType.DOCUMENTATION,
                    CommitType.ANNOTATING_ELEMENT,
                    CommitType.TEXTUAL_REPRESENTATION,
                    CommitType.COMMENT,
                    CommitType.ASSOCIATION,
                ]
        ),
        JsonSubTypes.Type(
                value = RelationshipCommitData::class,
                names = [
                    CommitType.RELATIONSHIP,
                    CommitType.ANNOTATION,
                    CommitType.VALUE_FEATURE,
                    CommitType.SPECIALIZATION,
                    CommitType.REFERENCING,
                    CommitType.FEATURE_TYPING,
                    CommitType.TYPE_FEATURING,
                    CommitType.NAMESPACE_IMPORT,
                ]
        )
)

abstract class CommitData(
    id: UUID,
    type: String,       // mandatory type of the metamodel as annotation
    var aliasIds: List<String> = ArrayList(),
    var declaredName: String? = null,
    var declaredShortName: String? = null,
    var documentation: Identified? = null,
    var elementId: String? = null,
    var isImpliedIncluded: Boolean? = null,
    var isLibraryElement: Boolean? = null,
    var name: String? = null,
    var ownedAnnotation: List<Identified> = ArrayList(),
    var ownedElement: List<Identified> = ArrayList(),
    var ownedRelationship: List<Identified> = ArrayList(),
    var owner: Identified? = null,
    var owningMembership: Identified? = null,
    var owningNamespace: Identified? = null,
    var owningRelationship: Identified? = null,
    var qualifiedName: String? = null,
    var shortName: String? = null,
    var textualRepresentation: List<Identified> = ArrayList(),

        // Additional attributes included in the Specification for some types of Commits
    var body: String? = null,
    var direction: String? = null,
    var language: String? = null,

): Identified(id) {
        @JsonProperty("@type")
        var type: String = type
}
