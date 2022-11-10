package cube

import kotlin.math.sqrt

class Cube(var pos: Vector3, var edgeSize: Float) {
    fun getFaces(): List<Array<Vector3>> {
        // distance offset between the center and a point of the cube
        val distOffset = edgeSize * sqrt(2f)

        /* calc points of cube (xyz) (p or n means positive or negative) */
        // back faces
        val npp = pos.add(Vector3(-distOffset, distOffset, distOffset))
        val ppp = pos.add(Vector3(distOffset, distOffset, distOffset))
        val nnp = pos.add(Vector3(-distOffset, -distOffset, distOffset))
        val pnp = pos.add(Vector3(distOffset, -distOffset, distOffset))

        // front faces
        val npn = pos.add(Vector3(-distOffset, distOffset,-distOffset))
        val ppn = pos.add(Vector3(distOffset, distOffset, -distOffset))
        val nnn = pos.add(Vector3(-distOffset, -distOffset, -distOffset))
        val pnn = pos.add(Vector3(distOffset, -distOffset, -distOffset))

        /* calc faces of cube (points ordered top left, top right, bottom right, bottom left) */
        val faceBack = arrayOf(npp, ppp, pnp, nnp)
        val faceRight = arrayOf(ppn, ppn, pnn, pnp)
        // TODO: add other faces

        /* return */
        return listOf<Array<Vector3>>(faceBack, faceRight)

    }
}
