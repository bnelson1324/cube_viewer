package cube

import kotlin.math.sqrt

class Cube(var pos: Vector3, var perspectiveOrigin: Vector3, private val edgeSize: Float, private val perspectiveMultiplier: Float) {

    fun getDisplayFaces(): List<Array<Vector3>> {
        // distance offset between the center and a point of the cube
        val distOffset = edgeSize * sqrt(2f)

        /* calc display points of cube (xyz) (p or n means positive or negative) */
        // back faces
        val npp = getPointDisplayPos(false, true, true, distOffset)
        val ppp = getPointDisplayPos(true, true, true, distOffset)
        val nnp = getPointDisplayPos(false, false, true, distOffset)
        val pnp = getPointDisplayPos(true, false, true, distOffset)

        // front faces
        val npn = getPointDisplayPos(false, true, false, distOffset)
        val ppn = getPointDisplayPos(true, true, false, distOffset)
        val nnn = getPointDisplayPos(false, false, false, distOffset)
        val pnn = getPointDisplayPos(true, false, false, distOffset)

        /* calc faces of cube (points ordered top left, top right, bottom right, bottom left) */
        val faceBack = arrayOf(npp, ppp, pnp, nnp)
        val faceFront = arrayOf(npn, ppn, pnn, nnn)
        val faceLeft = arrayOf(npn, npp, nnp, nnn)
        val faceRight = arrayOf(ppn, ppp, pnp, pnn)
        val faceBottom = arrayOf(nnp, pnp, pnn, nnn)
        val faceTop = arrayOf(npp, ppp, ppn, npn)

        /* return */
        return listOf<Array<Vector3>>(faceBack, faceFront, faceLeft, faceRight, faceBottom, faceTop)
    }

    private fun getPointDisplayPos(
        xPositive: Boolean,
        yPositive: Boolean,
        zPositive: Boolean,
        distOffset: Float
    ): Vector3 {
        // get position of point relative to pos
        val distOffsetX = distOffset * (if (xPositive) 1 else -1)
        val distOffsetY = distOffset * (if (yPositive) 1 else -1)
        val distOffsetZ = distOffset * (if (zPositive) 1 else -1)

        // calculate offset with perspective
        val offset = pos.add(Vector3(distOffsetX, distOffsetY, distOffsetZ))
        val offsetPerspective = offset.multiply(perspectiveMultiplier / (perspectiveOrigin.z + offset.z))

        // add offset to position and return
        return perspectiveOrigin.add(offsetPerspective)
    }
}
