import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val random = Random()

    val options = arrayOf("Камень", "Ножницы", "Бумага")

    var playerChoice: String
    var computerChoice: String

    do {
        println("Выберите: Камень, Ножницы или Бумага (для выхода введите 'Выход'): ")
        playerChoice = scanner.next().toLowerCase()

        if (playerChoice == "Выход") {
            break
        }

        if (playerChoice != "Камень" && playerChoice != "Ножницы" && playerChoice != "Бумага") {
            println("Неверный выбор. Пожалуйста, выберите Камень, Ножницы или Бумагу.")
            continue
        }

        val randomIndex = random.nextInt(3)
        computerChoice = options[randomIndex]

        println("Вы выбрали: $playerChoice")
        println("Компьютер выбрал: $computerChoice")

        val result = determineWinner(playerChoice, computerChoice)
        if (result == 0) {
            println("Ничья!")
        } else if (result == 1) {
            println("Вы победили!")
        } else {
            println("Компьютер победил!")
        }
    } while (true)

    println("Игра завершена.")
}

fun determineWinner(player: String, computer: String): Int {
    return when {
        (player == "Камень" && computer == "Ножницы") ||
                (player == "Ножницы" && computer == "Бумага") ||
                (player == "Бумага" && computer == "Камень") -> 1
        (computer == "Камень" && player == "Ножницы") ||
                (computer == "Ножницы" && player == "Бумага") ||
                (computer == "Бумага" && player == "Камень") -> -1
        else -> 0
    }
}