package com.smarttoolfactory.data.repository

import com.smarttoolfactory.data.model.local.PropertyEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

/**
 * This repository contains no data save, delete or fetch logic with Coroutines.
 *
 * All business logic for creating offline-first or offline-last approach is moved to UseCase
 */
interface PropertyRepositoryCoroutines {

    fun getCurrentPageNumber(): Int

    suspend fun fetchEntitiesFromRemote(orderBy: String): List<PropertyEntity>

    suspend fun fetchEntitiesFromRemoteByPage(page: Int, orderBy: String): List<PropertyEntity>

    suspend fun getPropertyEntitiesFromLocal(): List<PropertyEntity>

    suspend fun savePropertyEntities(propertyEntities: List<PropertyEntity>)

    suspend fun deletePropertyEntities()
}

/**
 * This repository contains no data save, delete or fetch logic with RxJava3.
 *
 * All business logic for creating offline-first or offline-last approach is moved to UseCase
 */
interface PropertyRepositoryRxJava3 {

    fun getCurrentPageNumber(): Int

    fun fetchEntitiesFromRemote(orderBy: String): Single<List<PropertyEntity>>

    fun fetchEntitiesFromRemoteByPage(page: Int, orderBy: String): Single<List<PropertyEntity>>

    fun getPropertyEntitiesFromLocal(): Single<List<PropertyEntity>>

    fun savePropertyEntities(propertyEntities: List<PropertyEntity>): Completable

    fun deletePropertyEntities(): Completable
}
