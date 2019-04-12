package LW3_1.test

import LW3_1.Car
import LW3_1.InvalidGearToChangeSpeed
import LW3_1.InvalidSpeedToChangeGear
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.nio.file.Files
import java.io.IOException



internal class CarTest {

    @Test
    fun changeGearToReverseAtNotZeroSpeed() {
        val car1 = Car(true, Car.MovingDirection.FORWARD, 10, Car.Gear.FIRST)
        assertThrows(InvalidSpeedToChangeGear::class.java) { car1.setGear(Car.Gear.REVERSE) }
        val car2 = Car(true, Car.MovingDirection.BACKWARD, 10, Car.Gear.REVERSE)
        assertThrows(InvalidSpeedToChangeGear::class.java) { car2.setGear(Car.Gear.REVERSE) }
    }

    @Test
    fun changeGearToFirstFromReverseAtNotZeroSpeed() {
        val car = Car(true, Car.MovingDirection.BACKWARD, 10, Car.Gear.REVERSE)
        assertThrows(InvalidSpeedToChangeGear::class.java) { car.setGear(Car.Gear.FIRST) }
        car.setGear(Car.Gear.NEUTRAL)
        assertThrows(InvalidSpeedToChangeGear::class.java) { car.setGear(Car.Gear.FIRST) }
    }

    @Test
    fun changeGearToReverseAtZeroSpeed() {
        val car = Car(true, Car.MovingDirection.FORWARD, 0, Car.Gear.FIRST)
        assertEquals(true, car.setGear(Car.Gear.REVERSE))
    }

    @Test
    fun raiseSpeedAtNeutralGear() {
        val car = Car(true, Car.MovingDirection.FORWARD, 30, Car.Gear.NEUTRAL)
        assertThrows(InvalidGearToChangeSpeed::class.java) { car.setSpeed(40) }
    }

    @Test
    fun reduceSpeedAtNeutralGear() {
        val car = Car(true, Car.MovingDirection.FORWARD, 30, Car.Gear.NEUTRAL)
        assertEquals(true, car.setSpeed(20))
    }
}