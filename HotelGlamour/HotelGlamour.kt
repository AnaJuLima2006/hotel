package HotelGlamour

var nome: String = ""
var hotel: String = "Hotel Glamour"
val listaHospedes = mutableListOf<String>() // Acessível por todas funções

fun main() {
    if (!logar()) {
        println("Suas chances acabaram, o program foi encerrado!")
        return
    }

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
    iniciar()
}

fun iniciar() {
    println("Bem vindo ao $hotel, $nome! É um enorme prazer ter você por aqui!\n")

    println(
        """Selecione uma opção:
        1. Cadastrar Hospedes
        2. Cadastrar Quartos
        3. Cadastrar Familia de Hospedes
        4. Reservar Eventos
        5. Sair Do Hotel"""
    )
    val escolha = readln().toIntOrNull()
    when (escolha) {
        1 -> cadastroDeHospedes()
        2 -> reservarQuartos()
        3 -> cadastrarFamiliaHospedes()
        4 -> reservarEventos()
        5 -> sairDoHotel()
        else -> erro()
    }
}

fun logar(): Boolean {
    var chances = 3
    val senhaCorreta = 2678

    while (chances > 0) {
        // Validação da senha
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
            return true  // Sai do loop quando a senha estiver correta
        } else {
            chances--
            println("Senha incorreta, tente novamente, voce não tem mais $chances chances!")
        }

    }
    return false
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
    println("Por favor, informe um número entre 1 e 3.")
    iniciar()
}
