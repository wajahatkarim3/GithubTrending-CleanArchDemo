package com.wajahatkarim.githtrending_clean.interactor.bookmark

import com.wajahatkarim.githtrending_clean.domain.PostExecutionThread
import com.wajahatkarim.githtrending_clean.interactor.ObservableUseCase
import com.wajahatkarim.githtrending_clean.model.ProjectModel
import com.wajahatkarim.githtrending_clean.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetBookmarkedProjects @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread) : ObservableUseCase<List<ProjectModel>, Nothing>(postExecutionThread)
{

    override fun buildUseCaseObservable(params: Nothing?): Observable<List<ProjectModel>> {
        return projectsRepository.getBookmarkedProjects()
    }
}