package com.wajahatkarim.githtrendingclean.domain

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}