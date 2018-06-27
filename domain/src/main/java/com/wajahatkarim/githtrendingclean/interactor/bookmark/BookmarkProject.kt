package com.wajahatkarim.githtrendingclean.interactor.bookmark

import com.wajahatkarim.githtrendingclean.domain.PostExecutionThread
import com.wajahatkarim.githtrendingclean.interactor.CompletableUseCase
import com.wajahatkarim.githtrendingclean.repository.ProjectsRepository
import io.reactivex.Completable
import io.reactivex.internal.operators.completable.CompletableUsing
import javax.inject.Inject

class BookmarkProject @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread) : CompletableUseCase<BookmarkProject.Params>(postExecutionThread)
{

    override fun buildUseCaseObservable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.bookmarkProject(params.projectId)
    }

    data class Params constructor(val projectId: String)
    {
        companion object {
            fun forProject(projectId: String) : Params = Params(projectId)
        }
    }
}