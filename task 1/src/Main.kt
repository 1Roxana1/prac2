//Задача 1.
//
//Создать программу, выполняющую следующий функционал:
//- запрашивается количество строк и столбцов для двумерного массива
//- вводится необходимое количество трехзначных чисел (числа могут повторяться)
//- подсчитывается количество различных цифр в полученном массиве
//- на консоль выводится двумерный массив из введенных чисел и количество различных цифр используемых в данном массиве
//Например, для массива
//100   951   101   950
//519   999   155   501
//510   911   144   554
//выведется результат: В массиве использовано 5 различных цифр

fun main() {
    print("Введите количество строк -> ")
    val rows = readLine()?.toIntOrNull() ?: return
    print("Введите количество столбцов -> ")
    val cols = readLine()?.toIntOrNull() ?: return

    val array = Array(rows) { IntArray(cols) }

    println("Введите ${rows * cols} трехзначных чисел:")
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            var pr = true
            while (pr)
            {
                val number = readLine()?.toIntOrNull()
                if (number != null && number in 100..999) {
                    array[i][j] = number
                    pr = false
                } else {
                    println("Введено не трехзначное число. Попробуйте еще раз.")
                }
            }

        }
    }


    for (row in array) {
        for (num in row) {
            print("$num \t")
        }
        println()
    }

    val uniqueDigits = mutableSetOf<Char>()
    for (row in array) {
        for (number in row) {
            number.toString().forEach { digit ->
                uniqueDigits.add(digit)
            }
        }
    }

    println("В массиве использовано ${uniqueDigits.size} различных цифр")
}
