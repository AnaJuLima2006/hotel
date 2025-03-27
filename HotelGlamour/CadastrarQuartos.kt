package HotelGlamour

import kotlin.system.exitProcess

val quartos = MutableList(20) { false }

fun cadastrarQuartos() {
    while (true) {
        println("""Cadastro de Quartos
        Selecione uma opção:
        1. Cadastrar diaria
        2. Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarDiaria()
            2 -> sairCadastroDeQuartos()
            else -> erroCadastroDeQuartos()
        }
    }
}
fun cadastrarDiaria() {

    while (true) {
        println("$nome, qual o valor da diária?")
        var diaria: Double
        while (true) {
            val input = readln().trim()
            if (input.isBlank()) {
                println("Valor não pode ser vazio! Digite o valor da diária:")
                continue
            }
            diaria = input.toDoubleOrNull() ?: 0.0
            if (diaria <= 0) {
                println("Valor inválido! Digite um número positivo:")
                continue
            }
            break
        }

        println("$nome, qual a quantidade de dias?")
        var dias: Int
        while (true) {
            val input = readln().trim()
            if (input.isBlank()) {
                println("Valor não pode ser vazio! Digite a quantidade de dias:")
                continue
            }
            dias = input.toIntOrNull() ?: 0
            if (dias <= 0 || dias > 30) {
                println("Valor inválido! Digite entre 1 e 30 dias:")
                continue
            }
            break
        }

        val valor = diaria * dias
        println("O valor da diária é R$ $valor")

        println("Qual o nome do hóspede?")
        var hospede = readln().trim()
        while (hospede.isBlank()) {
            println("Nome não pode ser vazio! Digite o nome do hóspede:")
            hospede = readln().trim()
        }

        // laço que veirfica se o hospede já foi cadastrado
        while (true) {
            if (listaHospedes.any { it.equals(hospede, ignoreCase = true) }) {
                println("Hóspede encontrado na lista!")
                break
            } else {
                println("""
                Hóspede não encontrado na lista!
                Deseja:
                1. Digitar o nome novamente
                2. Cadastrar novo hóspede
                3. Voltar ao menu""")

                when (readln().toIntOrNull()) {
                    1 -> {
                        println("Digite o nome do hóspede novamente:")
                        hospede = readln()
                    }
                    2 -> {
                        // Cadastra novo hóspede e mostra a lista completa
                        println("Cadastro de novo hóspede:")
                        var novoHospede: String
                        while (true) {
                            novoHospede = readln().trim()
                            if (novoHospede.isBlank()) {
                                println("Nome não pode ser vazio! Digite o nome do hóspede:")
                                continue
                            }
                            break
                        }
                        listaHospedes.add(novoHospede)
                        println("\nLista atualizada de hóspedes:")
                        println("Lista de Hóspedes atuais:\n" + listaHospedes.joinToString("\n"))

                        println("\nAgora digite o nome do hóspede para a reserva:")
                        hospede = readln()
                    }
                    3 -> return
                    else -> println("Opção inválida!")
                }
            }
        }

        // o usuario seleciona o quarto desejado
        var quarto: Int
        while(true) {
            println("$nome, qual o quarto desejado (1 - 20)?")
            val input = readln().trim()
            if (input.isBlank()) {
                println("Valor não pode ser vazio! Digite o número do quarto:")
                continue
            }
            quarto = input.toIntOrNull() ?: 0

            when {
                quarto !in 1..20 -> println("Quarto inválido!")
                quartos[quarto - 1] -> {
                    println("Quarto já está ocupado")
                }
                else -> {
                    quartos[quarto - 1] = true
                    break
                }
            }
        }

        //o usuario decide se quer confirmar a reserva
        println("Confirma reserva para $hospede no quarto $quarto por $dias dias? (S/N)")
        var resposta: String

        while (true) {
            resposta = readln().trim().uppercase()
            if (resposta.isBlank()) {
                println("Por favor, digite S ou N para confirmar:")
                continue
            }
            if (resposta == "S" || resposta == "N") {
                break
            }
            println("Opção inválida! Digite S ou N:")
        }

        when (readln().uppercase()) {
            "S" -> {
                println("Reserva confirmada!")
                print("\nStatus dos quartos: ")
                quartos.forEachIndexed { index, ocupado ->
                    val status = if (ocupado) "ocupado" else "livre"
                    println("${index + 1} - $status")
                    if (index != quartos.size - 1) {
                        print("; ")
                    }
                }

                println()
                return
            }
            "N" -> {
                quartos[quarto - 1] = false
                println("Reserva cancelada. Quarto $quarto liberado.")
                return
            }
        }
    }
}

fun sairCadastroDeQuartos() {
    println("Você deseja sair? S/N")
    val escolha = readln()

    when (escolha.uppercase()) {
        "S" -> {
            println("Hasta la vista, Baby.")
            exitProcess(0)
        }
        "N" -> iniciar()
        else -> {
            println("Desculpe, mas não compreendi.")
            sairCadastroDeQuartos()
        }
    }
}

fun erroCadastroDeQuartos() {
    println("Por favor, informe um número entre 1 e 2.")
    cadastrarQuartos()
}
