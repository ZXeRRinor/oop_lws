package LW3_1.test

import LW3_1.Car
import LW3_1.EngineStateException
import LW3_1.InvalidGearToChangeSpeed
import LW3_1.InvalidSpeedToSwitchGear
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*


internal class CarTest {

    @Test
    fun changeGearToReverseAtNotZeroSpeed() {
        val car1 = Car(true, Car.MovingDirection.FORWARD, 10, Car.Gear.FIRST)
        assertThrows(InvalidSpeedToSwitchGear::class.java) { car1.setGear(Car.Gear.REVERSE) }
        val car2 = Car(true, Car.MovingDirection.BACKWARD, 10, Car.Gear.REVERSE)
        assertThrows(InvalidSpeedToSwitchGear::class.java) { car2.setGear(Car.Gear.REVERSE) }
    }

    @Test
    fun changeGearToFirstFromReverseAtNotZeroSpeed() {
        val car = Car(true, Car.MovingDirection.BACKWARD, 10, Car.Gear.REVERSE)
        assertThrows(InvalidSpeedToSwitchGear::class.java) { car.setGear(Car.Gear.FIRST) }
        car.setGear(Car.Gear.NEUTRAL)
        assertThrows(InvalidSpeedToSwitchGear::class.java) { car.setGear(Car.Gear.FIRST) }
    }

    @Test
    fun changeGearToReverseAtZeroSpeed() {
        val car = Car(true, Car.MovingDirection.FORWARD, 0, Car.Gear.FIRST)
        assertEquals(true, car.setGear(Car.Gear.REVERSE))
    }

    @Test
    fun changeGearToFirstFromReverseAtZeroSpeed() {
        val car = Car(true, Car.MovingDirection.BACKWARD, 10, Car.Gear.REVERSE)
        car.setSpeed(0)
        assertEquals(true, car.setGear(Car.Gear.FIRST))
    }

    @Test
    fun increaseSpeedAtNeutralGear() {
        val car = Car(true, Car.MovingDirection.FORWARD, 30, Car.Gear.NEUTRAL)
        assertThrows(InvalidGearToChangeSpeed::class.java) { car.setSpeed(40) }
    }

    @Test
    fun decreaseSpeedAtNeutralGear() {
        val car = Car(true, Car.MovingDirection.FORWARD, 30, Car.Gear.NEUTRAL)
        assertEquals(true, car.setSpeed(20))
    }

    @Test
    fun secondaryStartingEngine() {
        val car = Car(true, Car.MovingDirection.STOP, 0, Car.Gear.NEUTRAL)
        assertThrows(EngineStateException::class.java) { car.turnOnEngine() }
    }

    @Test
    fun secondaryStopingEngine() {
        val car = Car(false, Car.MovingDirection.STOP, 0, Car.Gear.NEUTRAL)
        assertThrows(EngineStateException::class.java) { car.turnOffEngine() }
    }

    @Test
    fun startAndStopEngine() {
        val car = Car(false, Car.MovingDirection.STOP, 0, Car.Gear.NEUTRAL)
        assertEquals(true, car.turnOnEngine())
        assertEquals(true, car.turnOffEngine())
    }

    @Test
    fun tryToChangeSpeedWithTurnedOffEngine() {
        val car = Car(false, Car.MovingDirection.STOP, 0, Car.Gear.NEUTRAL)
        assertThrows(EngineStateException::class.java) { car.setSpeed(40) }
    }

    @Test
    fun tryToSwitchGearWithTurnedOffEngine() {
        val car = Car(false, Car.MovingDirection.STOP, 0, Car.Gear.NEUTRAL)
        assertThrows(EngineStateException::class.java) { car.setGear(Car.Gear.FIRST) }
        assertEquals(true, car.setGear(Car.Gear.NEUTRAL))
    }

    @Test
    fun tryToSwitchGearToCurrentGear() {
        val car = Car(true, Car.MovingDirection.STOP, 0, Car.Gear.NEUTRAL)
        assertEquals(true, car.setGear(Car.Gear.NEUTRAL))
        car.setGear(Car.Gear.FIRST)
        assertEquals(true, car.setGear(Car.Gear.FIRST))
    }
}