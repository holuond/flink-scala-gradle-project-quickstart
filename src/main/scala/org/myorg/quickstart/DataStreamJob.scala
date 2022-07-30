package org.myorg.quickstart

import org.apache.flink.api.common.RuntimeExecutionMode
import org.apache.flink.streaming.api.scala._

object DataStreamJob {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setRuntimeMode(RuntimeExecutionMode.AUTOMATIC)

    val inputStream: DataStream[Long] = env.fromSequence(0, 10)

    inputStream.filter(_ % 2 == 0)
      .name("keep even numbers")
      .map(_.toString + "is even!")
      .print()

    env.execute("Quickstart - print even numbers from 0 to 10")
  }
}
