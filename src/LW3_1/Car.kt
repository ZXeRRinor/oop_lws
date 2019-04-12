package LW3_1

class Car() {
    enum class MovingDirection(val value: Int) {
        FORWARD(1), BACKWARD(-1), STOP(0)
    }

    enum class Gear(val range: IntRange) {
        REVERSE(0..20), NEUTRAL(0..0), FIRST(0..30), SECOND(20..50),
        THIRD(30..60), FOURTH(40..90), FIFTH(50..150)
    }

    var isEngineStarted = false
    var currentMovingDirection = MovingDirection.STOP
    var currentSpeed = 0
    var currentGear = Gear.NEUTRAL

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


}
