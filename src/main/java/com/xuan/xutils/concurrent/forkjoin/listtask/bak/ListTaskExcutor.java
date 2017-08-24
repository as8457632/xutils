package com.xuan.xutils.concurrent.forkjoin.listtask.bak;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * 把一个List任务进行分解并发执行，对使用者又可以同步拿到数据
 * <p>
 * Created by xuan on 17/8/23.
 */
public class ListTaskExcutor<T, R> {

    /**
     * 执行提交的任务
     *
     * @param list             根据list来拆分任务，目前默认会把一个元素当做一个小任务执行，后期可以自己配置，以多少元素为一个小任务
     * @param listTaskCallable 具体任务执行逻辑，还是要用户自己实现
     * @return
     */
    public ListTaskResult<T, R> execute(List<T> list, ListTaskCallable<T, R> listTaskCallable) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ListTask<T, R> listTask = new ListTask<T, R>(list, listTaskCallable);
        Future<ListTaskResult<T, R>> future = forkJoinPool.submit(listTask);

        try {
            return future.get();
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        } catch (ExecutionException e) {
            e.fillInStackTrace();
        }
        return null;
    }

}
