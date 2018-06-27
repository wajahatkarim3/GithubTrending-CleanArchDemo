package com.wajahatkarim.githtrending_clean.domain

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}