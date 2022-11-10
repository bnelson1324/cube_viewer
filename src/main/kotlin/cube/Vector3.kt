package cube

class Vector3(var x: Float, var y: Float, var z: Float) {
    fun add(other: Vector3): Vector3 {
        return Vector3(x+other.x, y+other.y, z+other.z)
    }

    fun multiply(k: Float): Vector3 {
        return Vector3(x*k, y*k, z*k)
    }

    override fun toString(): String {
        return "($x, $y, $z)"
    }
}