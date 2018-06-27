package com.wajahatkarim.githtrending_clean.repository

import com.wajahatkarim.githtrending_clean.model.ProjectModel
import io.reactivex.Completable
import io.reactivex.Observable

interface ProjectsRepository {

    fun getProjects() : Observable<List<ProjectModel>>

    fun bookmarkProject(projectId: String) : Completable

    fun unbookmarkProject(projectId: String) : Completable

    fun getBookmarkedProjects() : Observable<List<ProjectModel>>

}