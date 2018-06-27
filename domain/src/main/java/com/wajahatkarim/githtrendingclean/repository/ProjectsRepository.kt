package com.wajahatkarim.githtrendingclean.repository

import com.wajahatkarim.githtrendingclean.model.ProjectModel
import io.reactivex.Completable
import io.reactivex.Observable

interface ProjectsRepository {

    fun getProjects() : Observable<List<ProjectModel>>

    fun bookmarkProject(projectId: String) : Completable

    fun unbookmarkProject(projectId: String) : Completable

    fun getBookmarkedProjects() : Observable<List<ProjectModel>>

}