package day01

import com.google.common.io.Files
import java.io.File

// https://adventofcode.com/2019/day/2
class Day02 {
    fun challenge1() {
        val path = this.javaClass.classLoader.getResource("input/day02")!!.file
        val input = Files.asCharSource(File(path), Charsets.UTF_8).read()

        val arr = input.split(',').map { it.toInt() }.toIntArray()
        for (i in 0..arr.size) {
            if (i % 4 == 0) {
                // 1,0,0,0,99
                if (arr[i] == 99) break;
                val val0 = arr[arr[i + 1]]
                val val1 = arr[arr[i + 2]]
                val pos2 = arr[i + 3]
                when (arr[i]) {
                    1 -> arr[pos2] = val0 + val1
                    2 -> arr[pos2] = val0 * val1
                }
            }
        }
        println(arr.joinToString())
    }

    fun challenge2() {
        val path = this.javaClass.classLoader.getResource("input/day02")!!.file
        val input = Files.asCharSource(File(path), Charsets.UTF_8).read()

        loop@ for (noun in 0..99) {
            for (verb in 0..99) {
                val arr = input.split(',').map { it.toInt() }.toIntArray()
                arr[1] = noun
                arr[2] = verb

                for (i in 0..arr.size) {
                    if (i % 4 == 0) {
                        if (arr[i] == 99) break;
                        val val0 = arr[arr[i + 1]]
                        val val1 = arr[arr[i + 2]]
                        val pos2 = arr[i + 3]
                        when (arr[i]) {
                            1 -> arr[pos2] = val0 + val1
                            2 -> arr[pos2] = val0 * val1
                        }
                    }
                }

                if (arr[0] == 19690720) {
                    println(noun)
                    println(verb)
                    break@loop;
                }
            }
        }
    }
}
