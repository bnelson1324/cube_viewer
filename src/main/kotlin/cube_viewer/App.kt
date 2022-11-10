package cube_viewer

import java.awt.Rectangle
import javax.swing.JFrame

class App(private val sizeX: Int, private val sizeY: Int) : JFrame("Cube Viewer") {
    init {
        bounds = Rectangle(sizeX, sizeY)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setLocationRelativeTo(null)

        val cubeDisplay = CubeDisplay(sizeX/2f, sizeY/2f)
        add(cubeDisplay)
    }
}