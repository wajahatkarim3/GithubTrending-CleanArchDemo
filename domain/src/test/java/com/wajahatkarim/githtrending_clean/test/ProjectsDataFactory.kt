package com.wajahatkarim.githtrending_clean.test

import com.wajahatkarim.githtrending_clean.model.ProjectModel
import java.util.*

object ProjectsDataFactory {

    fun randomUuid() : String = UUID.randomUUID().toString()

    fun randomBoolean() = Math.random() < 0.5

    fun makeProject() = ProjectModel(randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomBoolean())

    fun makeProjectList(count: Int) : List<ProjectModel> {
        val projects = mutableListOf<ProjectModel>()
        repeat(count)
        {
            projects.add(makeProject())
        }
        return projects
    }
}