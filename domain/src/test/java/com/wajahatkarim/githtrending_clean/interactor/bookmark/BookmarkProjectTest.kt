package com.wajahatkarim.githtrending_clean.interactor.bookmark

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import com.wajahatkarim.githtrending_clean.domain.PostExecutionThread
import com.wajahatkarim.githtrending_clean.model.ProjectModel
import com.wajahatkarim.githtrending_clean.repository.ProjectsRepository
import com.wajahatkarim.githtrending_clean.test.ProjectsDataFactory
import io.reactivex.Completable
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class BookmarkProjectTest {

    private lateinit var bookmarkProject: BookmarkProject
    @Mock lateinit var projectsRepository: ProjectsRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        bookmarkProject = BookmarkProject(projectsRepository, postExecutionThread)
    }

    @Test
    fun bookmarkProjectCompletes() {
        stubBookmarkProject(Completable.complete())
        val testObserver = bookmarkProject.buildUseCaseCompletable(
                BookmarkProject.Params.forProject(ProjectsDataFactory.randomUuid())).test()
        testObserver.assertComplete()
    }

    @Test(expected = IllegalArgumentException::class)
    fun bookmarkProjectThrowsException()
    {
        bookmarkProject.buildUseCaseCompletable().test()
    }

    private fun stubBookmarkProject(completable: Completable) {
        whenever(projectsRepository.bookmarkProject(any()))
                .thenReturn(completable)
    }
}