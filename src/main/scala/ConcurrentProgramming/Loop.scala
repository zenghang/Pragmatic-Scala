/*
 * Copyright 2017 pragmatic-scala.reactiveplatform.xyz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import scala.actors._
import Actor._
val caller = self
val accumulator = actor {
  var continue = true
  var sum = 0
  loopWhile(continue) {
    reactWithin(500) {
      case number : Int => sum += number
      case TIMEOUT => 
        continue = false
        caller ! sum
    }
  }
}

accumulator ! 1
accumulator ! 7
accumulator ! 8

receiveWithin(1000) { case result => println("Total is " + result) }
