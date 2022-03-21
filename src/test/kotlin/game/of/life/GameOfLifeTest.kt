package game.of.life

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

internal class GameOfLifeTest {

    @Test
    @Disabled
    fun testCellWithFewerThanTwoNeighboursDies() {
        val currentGeneration = arrayOf(
            "........",
            "....*...",
            "........",
            "........"
        )
        val expectedNextGeneration = arrayOf(
            "........",
            "........",
            "........",
            "........"
        )

        assertContentEquals(expectedNextGeneration, GameOfLife.calculateNextGeneration(currentGeneration))
    }

    @Test
    fun testCellWithThreeNeighboursComesAlive() {
        val currentGeneration = arrayOf(
            "........",
            "....*...",
            "...**...",
            "........"
        )
        val expectedNextGeneration = arrayOf(
            "........",
            "...**...",
            "...**...",
            "........"
        )

        assertContentEquals(expectedNextGeneration, GameOfLife.calculateNextGeneration(currentGeneration))
    }

    @Test
    fun returnsNewLineWithMiddleCellDead() {
        val currentGeneration = arrayOf(
            "...",
            ".*.",
            "..."
        )

        assertEquals("...", GameOfLife.getNextGenerationOfLine(1, currentGeneration))
    }

    @Test
    fun returnsNewLineWithMiddleCellStaysAlive() {
        val currentGeneration = arrayOf(
            ".*.",
            ".*.",
            ".*."
        )

        assertEquals(".*.", GameOfLife.getNextGenerationOfLine(1, currentGeneration))
    }

}