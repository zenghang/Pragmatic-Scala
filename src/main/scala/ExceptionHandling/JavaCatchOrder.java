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

package ExceptionHandling;

// #snip
//Java code—will not compile due to incorrect catch order
public class JavaCatchOrder {
  public void catchOrderExample() {
    try {
      String str = "hello";
      System.out.println(str.charAt(31));
    }
    catch(Exception ex) { System.out.println("Exception caught"); }
    catch(StringIndexOutOfBoundsException ex) { //ERROR
      System.out.println("Invalid Index"); }
  }
}
// #snip
