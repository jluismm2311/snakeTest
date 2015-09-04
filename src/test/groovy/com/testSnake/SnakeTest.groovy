package com.testSnake

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by jorgemoreno on 9/3/15.
 */
class SnakeTest extends Specification {

  Snake snake = new Snake()

  @Unroll
  void "is invalidMatrix n X n"(){
    when:
    snake.validateMatrix(matrix)
    then:
    thrown(Exception)
    where:
    matrix << [[[1, 2, 3, 4], [12, 13, 14], [11, 16, 15, 6], [10, 9, 8, 7]],
    [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7], [1,2,3,4]],
    [[1, 2, 3], [8, 9, 4], [7, 6]]]
  }

  @Unroll
  void "isValidPar"() {
    when:
    boolean result = snake.validateParMatrix(isPar, matrixSize, initialIndex)
    then:
    result == resultTest
    where:
    isPar | matrixSize | initialIndex | resultTest
    true  | 4          | 2            | false
    true  | 4          | 1            | true
    true  | 6          | 2            | true
    true  | 6          | 3            | false
    false | 5          | 2            | true
    false | 5          | 3            | true
    false | 5          | 1            | true

  }

  @Unroll
  void "have matrix"() {
    when:
    String result = snake.init(matrix)
    then:
    result
    result == matrixString
    where:
    matrix                                                          | matrixString
    [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]] | "1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 11 , 12 , 13 , 14 , 15 , 16"
    [[1, 2, 3], [8, 9, 4], [7, 6, 5]]                               | "1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9"
  }
}
