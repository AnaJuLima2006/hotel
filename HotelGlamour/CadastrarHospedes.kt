package HotelGlamour

import kotlin.system.exitProcess

fun cadastroDeHospedes() {
    // Inicializa a lista se estiver vazia
    if (listaHospedes.isEmpty()) {
        listaHospedes.addAll(listOf(
            "Carlos Villagran",
            "Maria Antonieta de las Nieves",
            "Roberto Gómez Bolaños",
            "Florinda Meza",
            "Ramón Valdés",
            "Rubén Aguirre",
            "Angelines Fernández",
            "Edgar Vivar",
            "Horácio Gómez Bolaños",
            "Raúl Padilla"
        ))
    }

    while (true) {
        println("""Cadastro de Hóspedes
        Selecione uma opção:
        1. Cadastrar hospede
        2. Pesquisar
        3. Cadastro familiar
        4. Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarNovoHospede()
            2 -> pesquisarHospede()
            3-> sairCadastrarHospedes()
            else -> erroCadastrarHospedes()
        }
    }
}

fun cadastrarNovoHospede() {
    println("Cadastro de Hóspedes.\nPor favor, informe o nome da Hóspede:")
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
    println("$novoHospede cadastrada com sucesso!")
    println("Lista de Hóspedes atuais:\n" + listaHospedes.joinToString("\n"))
}

fun pesquisarHospede() {
    println("Pesquisa de Hóspedes.\nPor favor, informe o nome da Hóspede:")
    val nomeHospede = readln()

    if (listaHospedes.any { it.contains(nomeHospede, ignoreCase = true) }) {
        println("\nEncontramos a(s) hóspede(s):")
        listaHospedes.filter { it.contains(nomeHospede, ignoreCase = true) }
            .forEach { println(it) }
    } else {
        println("Não encontramos nenhum(a) hóspede com esse nome.")
    }
}

fun sairCadastrarHospedes() {
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
            sairCadastrarHospedes()
        }
    }
}

fun erroCadastrarHospedes() {
    println("Por favor, informe um número entre 1 e 3.")
    cadastroDeHospedes()
}
