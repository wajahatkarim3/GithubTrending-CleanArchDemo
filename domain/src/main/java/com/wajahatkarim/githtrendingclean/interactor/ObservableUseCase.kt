package com.wajahatkarim.githtrendingclean.interactor

import com.wajahatkarim.githtrendingclean.domain.PostExecutionThread
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class ObservableUseCase<T, in Params> constructor(
        private val postExecutionThread: PostExecutionThread)
{
    protected abstract fun buildUseCaseObservable(params: Params? = null): Observable<T>

    private val disposables = CompositeDisposable()

    open fun execute(observer: DisposableObserver<T>, params: Params? = null) {
        val observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribeWith(observer))
    }

    fun dispose()
    {
        disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable)
    {
        disposables.add(disposable)
    }

}