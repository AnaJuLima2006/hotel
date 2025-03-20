package HotelGlamour

var nome : String = ""
var hotel : String = ""

fun main() {

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
    iniciar()

}

fun iniciar() {
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
        1 -> cadastrarQuartos()
        2 -> cadastrarHospedes()
        3 -> AbastecimentoDeAutomoveis()
        4 -> sairDoHotel()
        else -> erro()
    }
}


fun AbastecimentoDeAutomoveis() {

}

fun sairDoHotel() {
    println("Você deseja sair?\n Informe 1 para \"sim\" e 0 para \"não\"")
    val confirma = readln().toBoolean() // digite true ou false ou 1 ou 0
    if (confirma) {
        println("Muito obrigado e até logo, $nome.")
    } else {
        iniciar()
    }
}

fun erro(){
    println("Por favor, informe um número entre 1 e 4.")
    iniciar()
}