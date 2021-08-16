package com.xuan.mix.concurrent.listtask.executor;

import com.xuan.mix.concurrent.listtask.callback.ListTaskCallable;
import com.xuan.mix.concurrent.listtask.config.ListTaskConfig;
import com.xuan.mix.concurrent.listtask.core.ListTaskException;
import com.xuan.mix.concurrent.listtask.core.ListTaskResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用普通的线程池来实现，仅仅用来做测试对比，暂时不建议使用的
 * <p>
 *
 * @author xuan
 * @date 17/8/29
 */
public class CyclicBarrierExecutorImpl<T, R> implements ListTaskExecutor<T, R> {
    ExecutorService executor = Executors.newFixedThreadPool(10);

    @Override
    public ListTaskResult<R> execute(List<T> orignList, ListTaskCallable<T, R> callable, ListTaskConfig config) throws
        ListTaskException {
        throw new ListTaskException(new RuntimeException("no support"));
    }

    @Override
    public List<R> execute(List<T> orignList, ListTaskCallable<T, R> callable) throws ListTaskException {
        List<R> resultList = new CopyOnWriteArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(orignList.size());
        for (T t : orignList) {
            List<T> subOriginList = new ArrayList<>();
            subOriginList.add(t);
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    resultList.addAll(callable.call(subOriginList));
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public List<R> execute(List<T> orignList, ListTaskCallable<T, R> callable, int subOriginListSize)
        throws ListTaskException {
        throw new ListTaskException(new RuntimeException("no support"));
    }

}
