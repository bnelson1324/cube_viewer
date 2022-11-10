package cube_viewer

import cube.Cube
import cube.Vector3
import java.awt.BasicStroke
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel


class CubeDisplay(cubeX: Float, cubeY: Float): JPanel() {

    private val cube = Cube(Vector3(cubeX, cubeY, 200f), 50f)

    override fun paintComponent(g: Graphics) {
        val g2d: Graphics2D = g as Graphics2D
        super.paintComponent(g)
        g2d.clearRect(0, 0, width, height)
        g2d.stroke = BasicStroke(6f)
        drawCube(g2d)
    }

    // draws cube
    private fun drawCube(g: Graphics2D) {
        val faces = cube.getFaces()
        for(face in faces) {
            drawFace(g, face)
        }
    }

    // draws the lines of a face
    private fun drawFace(g: Graphics2D, face: Array<Vector3>) {
        // TODO: implement perspective (can multiply x and y values based on z-depth)
        for(i in 0 until 4) {
            val modNextIndex = (i+1)%4
            val x1: Int = face[i].x.toInt()
            val y1: Int = face[i].y.toInt()
            val x2: Int = face[modNextIndex].x.toInt()
            val y2: Int = face[modNextIndex].y.toInt()
            g.drawLine(x1, y1, x2, y2)
        }
    }

}

