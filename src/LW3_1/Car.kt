package LW3_1

class InvalidSpeedToSwitchGear(message: String) : Exception(message)
class InvalidGearToChangeSpeed(message: String) : Exception(message)
class EngineStateException(message: String) : Exception(message)

class Car() {
    enum class MovingDirection(val value: Int) {
        FORWARD(1), BACKWARD(-1), STOP(0)
    }

    enum class Gear(val number: Int, val speedRange: IntRange) {
        REVERSE(-1, 0..20), NEUTRAL(0, 0..150), FIRST(1, 0..30),
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

    fun turnOnEngine(): Boolean {
        if (!isEngineStarted) {
            isEngineStarted = true
        } else {
            throw EngineStateException("Engine is although tuned on.")
        }
        return true
    }

    fun turnOffEngine(): Boolean {
        if (isEngineStarted) {
            if (currentGear == Gear.NEUTRAL) {
                if (currentSpeed == 0) {
                    isEngineStarted = false
                } else {
                    throw EngineStateException("Engine can be turned off at zero speed only")
                }
            } else {
                throw EngineStateException("Engine can be turned off at neutral gear only.")
            }
        } else {
            throw EngineStateException("Engine is although tuned off.")
        }
        return true
    }

    fun setGear(gear: Gear): Boolean {
        if (isEngineStarted) {
            if (gear == Gear.REVERSE) {
                if (currentSpeed == 0) {
                    currentGear = gear
                    currentMovingDirection = MovingDirection.BACKWARD
                } else {
                    throw InvalidSpeedToSwitchGear("Reverse gear can be switched only at zero speed.")
                }
            }
            if (gear.number > 0) {
                if (currentGear == Gear.REVERSE) {
                    if (currentSpeed == 0) {
                        currentGear = gear
                        currentMovingDirection = MovingDirection.FORWARD
                    } else {
                        throw InvalidSpeedToSwitchGear("Gears from first to fifth can be be switched from reverse gear only at zero speed.")
                    }
                } else {
                    if (currentSpeed in gear.speedRange) {
                        currentGear = gear
                        currentMovingDirection = MovingDirection.FORWARD
                    }
                }
            }
        } else {
            if (gear != Gear.NEUTRAL) {
                throw EngineStateException("Gears other than neutral can be switched only when engine is started.")
            }
        }
        if (gear == Gear.NEUTRAL) {
            currentGear = gear
        }
        return true
    }

    fun setSpeed(speed: Int): Boolean {
        if (isEngineStarted) {
            if (speed in currentGear.speedRange) {
                currentSpeed = if (speed > currentSpeed) {
                    if (currentGear != Gear.NEUTRAL) {
                        speed
                    } else {
                        throw InvalidGearToChangeSpeed("Speed can't be increased at neutral gear.")
                    }
                } else {
                    speed
                }
                if (speed == 0) {
                    this.currentMovingDirection = MovingDirection.STOP
                }
            } else {
                throw InvalidGearToChangeSpeed("Speed out of range of current gear.")
            }
        } else {
            if (speed != 0) {
                throw EngineStateException("Speed can be more than zero only when engine is started.")
            }
        }
        return true
    }

}
