@file:Suppress("unused")

package io.github.tukcps.sysmlv2.api


/**
 * Interface of the SysML v2 API, following standard.
 */
interface SysMLv2Services: io.github.tukcps.sysmlv2.api.ProjectService,
    io.github.tukcps.sysmlv2.api.ElementNavigationService, io.github.tukcps.sysmlv2.api.ProjectDataVersioningService,
    io.github.tukcps.sysmlv2.api.ProjectUsageService