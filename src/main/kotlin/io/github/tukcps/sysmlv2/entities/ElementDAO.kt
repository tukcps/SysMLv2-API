package io.github.tukcps.sysmlv2.entities

import java.util.*


/**
 * Interface of exchanged abstract element representations.
 * All DAOs should inherit from this for the sake of interoperability.
 */
interface ElementDAO {
    var elementId: UUID
    var aliasIds: MutableList<String>
    var type: String
    var name: String?
    var shortName: String?
    var declaredName: String?
    var declaredShortName: String?
    var ownedElements: MutableList<io.github.tukcps.sysmlv2.entities.Identified>
    var owner: io.github.tukcps.sysmlv2.entities.Identified?
    var owningMembership: io.github.tukcps.sysmlv2.entities.Identified?
    var owningNamespace: io.github.tukcps.sysmlv2.entities.Identified?
    var owningRelationship: io.github.tukcps.sysmlv2.entities.Identified?
    var importedMemberName: String?
    var importedNamespace: String?

    // For type AnnotationElement, Expression:
    var language: String?
    var body: String?

    var isImplied: Boolean?
    var isImpliedIncluded: Boolean?
    var isStandard: Boolean?
    var isLibraryElement: Boolean?

    // Type
    var isAbstract: Boolean?
    var isSufficient: Boolean?
    var isConjugated: Boolean?

    // Feature
    var isUnique: Boolean?
    var isOrdered: Boolean?
    var isComposite: Boolean?
    var isEnd: Boolean?
    var isDerived: Boolean?
    var isReadOnly: Boolean?
    var direction: String?

    // Annotations
    var documentation: io.github.tukcps.sysmlv2.entities.Identified?
    var textualRepresentation: MutableList<io.github.tukcps.sysmlv2.entities.Identified>?

    // For Relationship and subtypes thereof:
    var source: MutableList<io.github.tukcps.sysmlv2.entities.Identified>?
    var target: MutableList<io.github.tukcps.sysmlv2.entities.Identified>?

    /**
     * A simple function that copies all fields from a source that implements the ElementDAO interface
     * @param source of data
     * @return the DAO with the copied data
     */
    @Suppress("unused")
    fun copyFrom(source: io.github.tukcps.sysmlv2.entities.ElementDAO): io.github.tukcps.sysmlv2.entities.ElementDAO {
        elementId = source.elementId
        type = source.type
        aliasIds = mutableListOf<String>().also { it.addAll(source.aliasIds) }
        name = source.name
        shortName = source.shortName
        declaredName = source.declaredName
        declaredShortName = source.declaredShortName
        owner = source.owner
        owningNamespace = source.owningNamespace
        owningRelationship = source.owningRelationship

        ownedElements = source.ownedElements.clone()
        direction = source.direction
        importedMemberName = source.importedMemberName
        importedNamespace = source.importedNamespace
        language = source.language
        body = source.body

        isImplied = source.isImplied
        isImpliedIncluded = source.isImpliedIncluded
        isStandard = source.isStandard
        isLibraryElement = source.isLibraryElement
        isAbstract = source.isAbstract
        isSufficient = source.isSufficient
        isConjugated = source.isConjugated
        isUnique = source.isUnique
        isOrdered = source.isOrdered
        isComposite = source.isComposite
        isEnd = source.isEnd
        isDerived = source.isDerived
        isReadOnly = source.isReadOnly

        textualRepresentation = source.textualRepresentation?.clone()
        documentation = source.documentation

        // For Relationship and subtypes thereof:
        this.source = source.source?.clone()
        this.target = source.target?.clone()
        return this
    }
}
