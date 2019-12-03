import com.google.common.io.Files
import java.io.File
import kotlin.math.floor

// https://adventofcode.com/2019/day/1
class Day01 {
    fun challenge12() {
        val path = this.javaClass.classLoader.getResource("input/day01")!!.file
        val input = Files.readLines(File(path), Charsets.UTF_8)!!

        var fuelRequirement = 0
        var fuelRequirementPart2 = 0
        input.forEach {
            var fuel = it.toDouble();
            var tmpFuelRequirement = (floor((fuel / 3)) - 2).toInt()
            fuelRequirement += tmpFuelRequirement

            while (tmpFuelRequirement > 0) {
                fuelRequirementPart2 += tmpFuelRequirement
                tmpFuelRequirement = (floor((tmpFuelRequirement.toDouble() / 3)) - 2).toInt()
            }
        }
        println("fuel requirement: $fuelRequirement")
        println("fuel requirement part 2: $fuelRequirementPart2")
    }
}