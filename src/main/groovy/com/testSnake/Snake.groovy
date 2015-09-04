package com.testSnake

/**
 * Created by jorgemoreno on 9/3/15.
 */
class Snake {
  String init(List matrix) {
    String castMatrix = ''
    validateMatrix(matrix, matrix.size())
    castMatrix = flowSnake(matrix, 0, matrix.size() - 1, castMatrix)
    println castMatrix
    castMatrix
  }

  void validateMatrix(matrix, int sizeMatrix) {
    matrix.each { row ->
      assert row.size() == sizeMatrix
    }
  }


  String flowSnake(List matrix, int initialIndex, int finishIndex, String matrixSnake) {
    Integer newInitialIndex = initialIndex + 1, newFinishIndex = finishIndex - 1
    boolean isPar = matrix.size() % 2 == 0, isValidParMatrix = validateParMatrix(isPar, matrix.size(), newInitialIndex)
    matrix.eachWithIndex { row, index ->
      if (index >= initialIndex && index <= finishIndex) {
        def subRow = row[initialIndex..finishIndex]
        if (index == initialIndex) {
          matrixSnake += subRow.join(' , ')
        } else if (index < finishIndex) {
          matrixSnake += " , ${subRow[finishIndex].toString()}"
        } else {
            matrixSnake += " , ${subRow.reverse().join(' , ')}"
          if(isValidParMatrix)
            (newFinishIndex..newInitialIndex).each {
              matrixSnake += " , ${matrix[it][initialIndex].toString()}"
            }
        }
      }
    }
    if ((isPar && isValidParMatrix) || (matrix.size()%2 != 0 && finishIndex - initialIndex > 1)) {
      matrixSnake += " , "
      flowSnake(matrix, newInitialIndex, newFinishIndex, matrixSnake)
    }else{
      matrixSnake
    }
  }

  boolean validateParMatrix(boolean isPar, int matrixSize, int initialIndex){
    boolean isValid = !isPar
    if(isPar && matrixSize / 2 > initialIndex){
      isValid = true
    }
    isValid
  }
}
