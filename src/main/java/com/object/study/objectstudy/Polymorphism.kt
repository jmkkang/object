//package com.`object`.study.objectstudy
//
//import java.sql.DriverManager.println
//
///**
// *
// * Polymorphism 다형성
// *
// * Substituion : 대체가능성
// * Internal identity : 내적동질성
// *
// */
//
////implement
//open class Worker : Runnable {
//    override fun run() = println("working")
//    fun print() = println(run())
//}
//
//class HardWorker : Worker() {
//    override fun run() = println("HardWorking")
//}
//
///**
//클래스 형으로 Runnable/Worker 둘 중 하나를 사용할 수 있지만
//Runnable을 사용함으로써 Runnable의 집합만을 사용할 수 있다.
//Runnable의 run->Worker의 run에 매핑
//Runnable의 run의 포인터를 찾아 참조되어 있는 구현메소드(Worker의 run)를 찾아 실행.
//
//런타임시 Worker instance / Runnable instance 둘 다 생기지만 :Runnable로 형을 지정해줌으로써
//Runnable에 인터페이스에 대한 포인터를 worker에 위임해준것
//
//지정된 형에 대한 포인터를 노출해줌으로써 진짜 구현된 곳까지는 포인터로 대체해주는 행위가 대체가능성임.
//= 동적바인딩 - 런타임시 포인터에 연쇄로 계산을 해야하기때문
// */
//var worker: Runnable = Worker()
//println(worker.run())
//
//worker = HardWorker()
//print(worker.run())
//
///**
// * 내적동질성
// * 클래스형이 달라도 출신클래스에 따른 메소드가 실행되도록 정함.
// */
//open class Worker:Runnable{
//    override fun run() = println("working")
//    fun print() = println(run())
//}
//class HardWorker:Worker(){
//    override fun run() = println("HardWorking")
//}
//var worker:Worker = HardWorker()
//println(worker.print())
///**
// * 형이 바뀌어도 태어난 출신을 우선으로 한다.
// */
//
