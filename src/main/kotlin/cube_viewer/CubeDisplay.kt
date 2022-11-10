package cube_viewer

import cube.Cube
import cube.Vector3
import java.awt.BasicStroke
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JPanel
import javax.swing.SwingUtilities


class CubeDisplay(cubeX: Float, cubeY: Float) : JPanel() {

    private val perspectiveConst: Float = 50f

    private val cube = Cube(Vector3(0f, 0f, 200f), Vector3(cubeX, cubeY, -100f), 50f, perspectiveConst)

    init {
        addMouseMotionListener(object : MouseAdapter() {
            override fun mouseMoved(e: MouseEvent?) {
                super.mouseMoved(e)
                if(e?.x == null || e?.y == null) {
                    return
                }
                val newX = e!!.x - width/2
                val newY = e!!.y - height/2
                cube.pos = Vector3(newX.toFloat(), newY.toFloat(), cube.pos.z)
                SwingUtilities.invokeLater { repaint() }

            }
        })
    }

    /* drawing cube */
    override fun paintComponent(g: Graphics) {
        // draw cube
        val g2d: Graphics2D = g as Graphics2D
        super.paintComponent(g)
        g2d.clearRect(0, 0, width, height)
        g2d.stroke = BasicStroke(6f)
        drawCube(g2d)

        // move perspectiveOrigin to center of JPanel
        cube?.perspectiveOrigin = Vector3(width/2f, height/2f, cube.perspectiveOrigin.z)
    }

    // draws cube
    private fun drawCube(g: Graphics2D) {
        val faces = cube.getDisplayFaces()
        for(face in faces) {
            drawFace(g, face)
        }
    }

    // draws the lines of a face
    private fun drawFace(g: Graphics2D, face: Array<Vector3>) {
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

