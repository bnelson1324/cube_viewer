import java.awt.Rectangle
import javax.swing.JFrame

class App(private val sizeX: Int, private val sizeY: Int) : JFrame("Cube Viewer") {
    init {
        bounds = Rectangle(sizeX, sizeY)
        isVisible = true
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }
}