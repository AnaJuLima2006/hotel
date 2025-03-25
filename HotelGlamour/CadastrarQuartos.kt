package HotelGlamour

import kotlin.system.exitProcess

val quartos = MutableList(20) { false }

fun cadastrarQuartos(listaHospedes: MutableList<String>) {


    while (true) {
        println("""Cadastro de Quartos
        Selecione uma opção:
        1. Cadastrar diaria
        2. Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarDiaria(listaHospedes)
            2 -> sairCadastroDeQuartos()
            else -> erroCadastroDeQaurtos()

        }
    }
}

fun cadastrarDiaria(listaHospedes: List<String>){
    while (true) {

        println("$nome, qual o valor da diária?")
        val diaria = readln().toDoubleOrNull() ?: 0.0
        println("$nome, qual a quantidade de dias?")
        val dias = readln().toIntOrNull() ?: 0

        if (diaria <= 0 || dias <= 0 || dias > 30) {
            println("Valor Inválido!")
            continue // Volta ao início
        }

        val valor = diaria * dias
        println("O valor da diária é R$ $valor")

        println("Qual o nome do hóspede?")
        val hospede = readln()
        var quarto : Int
        while(true) {
            println("$nome, qual o quarto desejado (1 - 20)?")
            quarto = readln().toIntOrNull() ?: 0

            when {
                quarto !in 1..20 -> println("Quarto inválido!")
                quartos[quarto - 1] -> println("Quarto já está ocupado")
                else -> {
                    quartos[quarto - 1] = true // Reserva o quarto
                    break
                }
            }
        }

        println("Confirma reserva para $hospede no quarto $quarto por $dias dias? (S/N)")
        when (readln().uppercase()) {
            "S" -> {
                println("Reserva confirmada!")
                return // Sai da função após confirmação
            }
            else -> {
                quartos[quarto - 1] = false // Libera o quarto
                return // Volta ao menu principal
            }
        }
    }
}
fun sairCadastroDeQuartos() {
    println("Você deseja sair? S/N")
    val escolha = readln()

    when (escolha.uppercase()) {
        // uppercase fará o que for digitado ser convertido para maiúsculo por exemplpo x -> X
        "S" -> {
            println("Hasta la vista, Baby.")
            exitProcess(0)
        }
        "N" -> {
            println("Ok, voltando ao início.")
            cadastrarHospedes()
        }
        else -> {
            println("Desculpe, mas não compreendi.")
            sairCadastroDeHospedes()
        }
    }
}

fun erroCadastroDeQaurtos() {
    println("Por favor, informe um número entre 1 e 3.")
}
