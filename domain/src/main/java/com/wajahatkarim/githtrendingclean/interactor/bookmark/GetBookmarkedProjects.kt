package com.wajahatkarim.githtrendingclean.interactor.bookmark

import com.wajahatkarim.githtrendingclean.domain.PostExecutionThread
import com.wajahatkarim.githtrendingclean.interactor.ObservableUseCase
import com.wajahatkarim.githtrendingclean.model.ProjectModel
import com.wajahatkarim.githtrendingclean.repository.ProjectsRepository
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