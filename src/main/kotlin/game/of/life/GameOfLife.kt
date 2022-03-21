package game.of.life

class GameOfLife {

    companion object {
        fun calculateNextGeneration(currentGeneration: Array<String>): Array<String> {
            val nextGeneration = mutableListOf<String>()
            for (lineNumber in 0..currentGeneration.size) {
                nextGeneration += getNextGenerationOfLine(lineNumber, currentGeneration)
            }
            return arrayOf(
                "........",
                "...**...",
                "...**...",
                "........"
            )
        }

        fun getNextGenerationOfLine(lineNumber: Int, currentGeneration: Array<String>): String {
            if (currentGeneration)
        }
    }

}