package com.wajahatkarim.githtrending_clean.interactor.browse

import com.nhaarman.mockito_kotlin.whenever
import com.wajahatkarim.githtrending_clean.domain.PostExecutionThread
import com.wajahatkarim.githtrending_clean.model.ProjectModel
import com.wajahatkarim.githtrending_clean.repository.ProjectsRepository
import com.wajahatkarim.githtrending_clean.test.ProjectsDataFactory
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetProjectsUseCaseTest {

    private lateinit var getProjects: GetProjectsUseCase
    @Mock lateinit var projectsRepository: ProjectsRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getProjects = GetProjectsUseCase(projectsRepository, postExecutionThread)
    }

    @Test
    fun getProjectsCompletes() {
        stubGetProjects(Observable.just(ProjectsDataFactory.makeProjectList(2)))
        val testObserver = getProjects.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProjectsData() {
        val projectss = ProjectsDataFactory.makeProjectList(2)
        stubGetProjects(Observable.just(projectss))
        val testObserver = getProjects.buildUseCaseObservable().test()
        testObserver.assertValue(projectss)
    }

    private fun stubGetProjects(observable: Observable<List<ProjectModel>>)
    {
        whenever(projectsRepository.getProjects())
                .thenReturn(observable)
    }
}