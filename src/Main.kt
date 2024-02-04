// Implementor interface
interface DrawingAPI {
    fun drawCircle(radius: Int, x: Int, y: Int)
    fun drawSquare(side: Int, x: Int, y: Int)
}

// Concrete Implementor 1
class DrawingAPI1 : DrawingAPI {
    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("API1 - Drawing Circle [Radius: $radius, Center: ($x, $y)]")
    }

    override fun drawSquare(side: Int, x: Int, y: Int) {
        println("API1 - Drawing Square [Side: $side, Position: ($x, $y)]")
    }
}

// Concrete Implementor 2
class DrawingAPI2 : DrawingAPI {
    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("API2 - Drawing Circle [Radius: $radius, Center: ($x, $y)]")
    }

    override fun drawSquare(side: Int, x: Int, y: Int) {
        println("API2 - Drawing Square [Side: $side, Position: ($x, $y)]")
    }
}

// Abstraction
abstract class Shape(protected val drawingAPI: DrawingAPI) {
    abstract fun draw()
}

// Refined Abstraction 1
class Circle(private val radius: Int, x: Int, y: Int, drawingAPI: DrawingAPI) : Shape(drawingAPI) {
    private val centerX: Int = x
    private val centerY: Int = y

    override fun draw() {
        drawingAPI.drawCircle(radius, centerX, centerY)
    }
}

// Refined Abstraction 2
class Square(private val side: Int, x: Int, y: Int, drawingAPI: DrawingAPI) : Shape(drawingAPI) {
    private val positionX: Int = x
    private val positionY: Int = y

    override fun draw() {
        drawingAPI.drawSquare(side, positionX, positionY)
    }
}

// Client code
fun main() {
    val api1 = DrawingAPI1()
    val api2 = DrawingAPI2()

    val circle1 = Circle(5, 10, 15, api1)
    val square1 = Square(4, 7, 8, api1)

    val circle2 = Circle(3, 5, 2, api2)
    val square2 = Square(6, 9, 4, api2)

    circle1.draw()
    square1.draw()

    circle2.draw()
    square2.draw()
}
