import cube_viewer.App
import javax.swing.SwingUtilities

fun main() {
    SwingUtilities.invokeLater(::startApp)
}

private fun startApp() {
    val app = App(800, 600)
    app.isVisible = true
}