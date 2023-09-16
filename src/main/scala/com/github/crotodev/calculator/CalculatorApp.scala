package com.github.crotodev.calculator

import scala.io.StdIn

object CalculatorApp {

  def main(args: Array[String]): Unit = {
    while (true) {
      val line = StdIn.readLine("calculator> ")
      val split = line.split(" ")
      if (split.length % 2 == 0) {
        println("Invalid input")
      } else {
        val numbers = split.filter(_.matches("[0-9]+")).map(_.toInt)
        val operators = split.filter(_.matches("[+-/*]"))
        val result = numbers.zip(operators).foldLeft(0) {
          case (acc, (number, operator)) =>
            operator match {
              case "+" => acc + number
              case "-" => acc - number
              case "*" => acc * number
              case "/" => acc / number
            }
        }
        println(result)
      }
    }
  }
}
