package HotelGlamour

var nome : String = ""
var hotel : String = ""

fun main(listaHospedes: MutableList<String>) {

    var senhaCorreta = 2678
    println("Qual é o seu nome?")
    nome = readln()
    println("Digite a sua senha:")
    var senha = readln().toInt()

    while(senha != senhaCorreta){
        println("Senha incorreta, tente novamente!")
        println("\nDigite a sua senha:")
        senha = readln().toInt()
    }
    iniciar(listaHospedes)

}

fun iniciar(listaHospedes: MutableList<String>) {
    hotel = "Hotel Glamour"
    println("Bem vindo ao $hotel, $nome! " +
            "É um enorme prazer ter você por aqui!\n")

    println("""Selecione uma opção:
        1. Cadastrar Quartos
        2. Cadastrar Hospedes
        3. Abastecimento de automóveis
        4. Sair""")
    val escolha = readln().toIntOrNull()
    when (escolha) {
        1 -> cadastrarQuartos(listaHospedes)
        2 -> cadastrarHospedes()
        3 -> AbastecimentoDeAutomoveis()
        4 -> sairDoHotel(listaHospedes)
        else -> erro(listaHospedes)
    }
}


fun AbastecimentoDeAutomoveis() {

}

fun sairDoHotel(listaHospedes: MutableList<String>) {
    println("Você deseja sair?\n Informe 1 para \"sim\" e 0 para \"não\"")
    val confirma = readln().toBoolean() // digite true ou false ou 1 ou 0
    if (confirma) {
        println("Muito obrigado e até logo, $nome.")
    } else {
        iniciar(listaHospedes)
    }
}

fun erro(listaHospedes: MutableList<String>){
    println("Por favor, informe um número entre 1 e 4.")
    iniciar(listaHospedes)
}
