package HotelGlamour

var nome: String = ""
var hotel: String = ""
val listaHospedes = mutableListOf<String>() // Acessível por todas funções

fun main() {
    // Validação do nome
    while (true) {
        println("Qual é o seu nome?")
        nome = readln().trim()
        if (nome.isBlank()) {
            println("Nome não pode ser vazio! Digite o seu nome:")
        } else {
            break
        }
    }

    val senhaCorreta = 2678

    // Validação da senha
    while (true) {
        println("Digite a sua senha:")
        val input = readln().trim()

        if (input.isBlank()) {
            println("Senha não pode ser vazia!")
            continue
        }

        val senha = input.toIntOrNull()

        if (senha == null) {
            println("Por favor, digite um número válido!")
            continue
        }

        if (senha == senhaCorreta) {
            break  // Sai do loop quando a senha estiver correta
        } else {
            println("Senha incorreta, tente novamente!")
        }
    }

    iniciar()
}

fun iniciar() {
    hotel = "Hotel Glamour"
    println("Bem vindo ao $hotel, $nome! É um enorme prazer ter você por aqui!\n")

    println("""Selecione uma opção:
        1. Cadastrar Hospedes
        2. Cadastrar Quartos
        3. Abastecimento de automóveis
        4. Sair""")
    val escolha = readln().toIntOrNull()
    when (escolha) {
        1 -> cadastrarHospedes()
        2 -> cadastrarQuartos()
        3 -> abastecimentoDeAutomoveis()
        4 -> sairDoHotel()
        else -> erro()
    }
}

fun abastecimentoDeAutomoveis() {

}

fun sairDoHotel() {
    println("Você deseja sair?\n Informe 1 para \"sim\" e 0 para \"não\"")
    val confirma = readln().toBoolean()
    if (confirma) {
        println("Muito obrigado e até logo, $nome.")
    } else {
        iniciar()
    }
}

fun erro() {
    println("Por favor, informe um número entre 1 e 4.")
    iniciar()
}
