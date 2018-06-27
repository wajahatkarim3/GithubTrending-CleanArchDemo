package com.wajahatkarim.githtrending_clean.interactor.bookmark

import com.wajahatkarim.githtrending_clean.domain.PostExecutionThread
import com.wajahatkarim.githtrending_clean.interactor.CompletableUseCase
import com.wajahatkarim.githtrending_clean.repository.ProjectsRepository
import io.reactivex.Completable
import javax.inject.Inject

class UnbookmarkProject @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread) : CompletableUseCase<UnbookmarkProject.Params>(postExecutionThread)
{

    override fun buildUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.unbookmarkProject(params.projectId)
    }

    data class Params constructor(val projectId: String)
    {
        companion object {
            fun forProject(projectId: String) : Params = Params(projectId)
        }
    }
}