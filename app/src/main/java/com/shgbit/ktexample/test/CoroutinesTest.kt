package com.shgbit.ktexample.test

import com.shgbit.ktexample.util.PLog
import kotlinx.coroutines.*

/**
 * @author xushun on  2020/5/6 15:30.
 * Email：shunplus@163.com
 * Des：协程
 */
object CoroutinesTest {
    val TAG = "CoroutinesTest";
    //协程  优点
    //更轻量级的 api 实现协程
    //async 和 await 不作为标准库的一部分
    //suspend 函数，也就是挂起函数是比 java future 和 promise 更安全并且更容易使用

    //launch{} , runBlocking{} ,async{}
    // 1,launch{} 会在当前线程开启一个新的协程，并且不会阻塞当前线程，同时会返回一个 Job 做为 coroutine 
    // 的引用，你可以通过这个 Job 取消对应的 Coroutine。
    //2,runBlocking {} 会在开启一个新的协程，并且阻塞当前进程，直到操作完成。这个函数不应该在协程里面使用，
    // 它是用来桥接需要阻塞的挂起函数，主要用于 main function 和 junit 测试。也就是说，runBolcking {} 
    // 必须用在最上层。
    // 3,async{} 会在对应的 CoroutineContext 下创建一个新的协程，并且放回一个Deferred，通过 Deferred 
    // 可以异步获取结果，也就是调用Deffered 的 await() 方法。


    // 在 launch 里面会创建一个新的 CoroutineContext，如果没有传入 Context 则使用的 EmptyCoroutineContext,
    // 通过 newCoroutineContext() 函数会分配一个默认的 Dispatcher，也就是 Dispatcher.default,默认的全局
    // Dispatcher，会在jvm 层级共享线程池，会创建等于cpu 内核数目的线程（但是至少创建两个子线程）。接着判
    // 断 CoroutineStart 是否 Lazy 模式，如果 Lazy 模式，则该 Coroutine 不会立马执行，需要你主动掉了 
    // Job.start() 之后才会执行。


    fun test() {

        //非阻塞 子线程
        GlobalScope.launch {
            PLog.i(TAG, "launch before " + System.currentTimeMillis())
            delay(1000L)
            PLog.i(TAG, "launch after " + System.currentTimeMillis())
        }
        PLog.i(TAG, "launch  out ----------- " + System.currentTimeMillis())

        GlobalScope.async {
            PLog.i(TAG, "async before " + System.currentTimeMillis())
            delay(1000L)
            PLog.i(TAG, "async after " + System.currentTimeMillis())
        }
        PLog.i(TAG, "async out ------" + System.currentTimeMillis())

        //阻塞 主线程运行
        PLog.i(TAG, "runBlocking  before " + System.currentTimeMillis())
        runBlocking {
            delay(3000L)
        }
        PLog.i(TAG, "runBlocking   out ----------- " + System.currentTimeMillis())
    }

    /**
     *   使用join方法  等待任务一完成后 方可启动任务二
     */
    fun testWaitJob() {
        //任务一
        var job = GlobalScope.launch {
            PLog.i(TAG, "testWait before " + System.currentTimeMillis())
            delay(3000L)
            PLog.i(TAG, "testWait after " + System.currentTimeMillis())
        }
        //任务二
        GlobalScope.launch {
            job.join()
            PLog.i(TAG, "testWait join " + System.currentTimeMillis())
        }

    }


    fun testCancel() {

        var job = GlobalScope.launch {
            for (index in 0..30) {
                PLog.i(TAG, "testCancel $index " + System.currentTimeMillis())
                delay(100L)
            }

        }

        GlobalScope.launch {
            delay(1000L)
            PLog.i(TAG, "testCancel do cancel " + System.currentTimeMillis())
            job.cancel()
        }

    }


    //  可返回结果的
    fun testAsync() {
        GlobalScope.launch {
            val result = async {
                getNubber()
            }.await()
            PLog.i(TAG, "testAsync result$result")
        }
    }

    suspend fun getNubber(): Int {
        return 1
    }


    //  测试多 任务协程
    fun postItem() {
        GlobalScope.launch {
            // async { requestToken() } 新建一个协程，可能在另一个线程运行
            // 但是 await() 是挂起函数，当前协程执行逻辑卡在第一个分支，第一种状态，当 async 的协程执行完后恢复当前协程，才会切换到下一个分支
            val token = async { requestToken() }.await()
            // 在第二个分支状态中，又新建一个协程，使用 await 挂起函数将之后代码作为 Continuation 放倒下一个分支状态，直到 async 协程执行完
            val post = async { login(token) }.await()
            // 最后一个分支状态，直接在当前协程处理
            processPost(post)
        }
    }

    suspend fun requestToken(): Int {
        return 1
    }


    suspend fun login(token: Int): Boolean {
        return true
    }

    fun processPost(result2: Boolean) {
        PLog.i(TAG, "testAsync result2=$result2")
    }


}
