package LW3_1

class InvalidSpeedToChangeGear(message: String) : Exception(message)
class InvalidGearToChangeSpeed(message: String) : Exception(message)

class Car() {
    enum class MovingDirection(val value: Int) {
        FORWARD(1), BACKWARD(-1), STOP(0)
    }

    enum class Gear(val number: Int, val speedRange: IntRange) {
        REVERSE(-1, 0..20), NEUTRAL(0, 0..0), FIRST(1, 0..30),
        SECOND(2, 20..50), THIRD(3, 30..60), FOURTH(4, 40..90),
        FIFTH(5, 50..150)
    }

    private var isEngineStarted = false
    private var currentMovingDirection = MovingDirection.STOP
    private var currentSpeed = 0
    private var currentGear = Gear.NEUTRAL

    constructor(
        engineStatus: Boolean,
        direction: MovingDirection,
        speed: Int,
        gear: Gear
    ) : this() {
        isEngineStarted = engineStatus
        currentSpeed = speed
        currentMovingDirection = direction
        currentGear = gear
    }

    fun turnOnEngine() {
        if(!this.isEngineStarted) {
            this.isEngineStarted = true
        }
    }

    fun turnOffEngine() {
        if(this.isEngineStarted && this.currentGear == Gear.NEUTRAL && this.currentSpeed == 0){
            this.isEngineStarted = false
        }
    }

    fun setGear(gear: Gear) {

    }

    fun setSpeed(speed: Int) {

    }

}
