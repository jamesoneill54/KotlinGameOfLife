package game.of.life

class GameOfLife {

    companion object {
        fun calculateNextGeneration(currentGeneration: Array<String>): Array<String> {
            val nextGeneration = mutableListOf<String>()
            for (lineNumber in currentGeneration.indices) {
                nextGeneration += getNextGenerationOfLine(lineNumber, currentGeneration)
            }
            return nextGeneration.toTypedArray()
        }

        fun getNextGenerationOfLine(lineNumber: Int, currentGeneration: Array<String>): String {
            var nextGenerationOfLine = ""
            for (cellNumber in currentGeneration[lineNumber].indices) {
                nextGenerationOfLine += getNextGenerationOfCell(cellNumber, lineNumber, currentGeneration)
            }
            return nextGenerationOfLine
        }

        private fun getNextGenerationOfCell(cellNumber: Int, lineNumber: Int, currentGeneration: Array<String>): Char {
            var numberOfLiveNeighbours = 0
            if (cellIsAlive(cellNumber - 1, lineNumber - 1, currentGeneration)) numberOfLiveNeighbours++
            if (cellIsAlive(cellNumber, lineNumber - 1, currentGeneration)) numberOfLiveNeighbours++
            if (cellIsAlive(cellNumber + 1, lineNumber - 1, currentGeneration)) numberOfLiveNeighbours++
            if (cellIsAlive(cellNumber - 1, lineNumber, currentGeneration)) numberOfLiveNeighbours++
            if (cellIsAlive(cellNumber + 1, lineNumber, currentGeneration)) numberOfLiveNeighbours++
            if (cellIsAlive(cellNumber - 1, lineNumber + 1, currentGeneration)) numberOfLiveNeighbours++
            if (cellIsAlive(cellNumber, lineNumber + 1, currentGeneration)) numberOfLiveNeighbours++
            if (cellIsAlive(cellNumber + 1, lineNumber + 1, currentGeneration)) numberOfLiveNeighbours++

            if (numberOfLiveNeighbours < 2) return '.'
            if (numberOfLiveNeighbours == 2) return currentGeneration[lineNumber][cellNumber]
            if (numberOfLiveNeighbours == 3) return '*'
            return '.'
        }

        private fun cellIsAlive(cellNumber: Int, lineNumber: Int, currentGeneration: Array<String>): Boolean {
            return try {
                currentGeneration[lineNumber][cellNumber] == '*'
            } catch (e: StringIndexOutOfBoundsException) {
                false
            } catch (e: ArrayIndexOutOfBoundsException) {
                false
            }
        }
    }

}