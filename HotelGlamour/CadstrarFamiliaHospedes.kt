package HotelGlamour

import kotlin.system.exitProcess

fun cadastrarFamiliaHospedes() {


    while (true) {
        println("""Cadastro de Hóspedes
        Selecione uma opção:
        1. Cadastro familiar
        2. Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarFamilia()
            2 -> sairCadastrarFamilia()
            else -> erroCadastrarFamilia()
        }
    }
}
fun cadastrarFamilia(){
    println("Cadastro familiar")

    //o ususario informa o valor padrão da diário
    var diaria : Double
    while (true) {
        println("Digite o valor da diária:")
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


    var dias: Int
    while (true) {
        println("Quantos dias a família ficará hospedada? (Máximo 30 dias)")
        val input = readln().trim()
        if (input.isBlank()) {
            println("Valor não pode ser vazio! Digite a quantidade de dias:")
            continue
        }
        dias = input.toIntOrNull() ?: 0
        if (dias <= 0 || dias > 30) {
            println("Número inválido! Digite entre 1 e 30 dias.")
            continue
        }
        break
    }

    //variaveis que contam quem tem gratuidade, meia ou nenhum dos dois
    var gratuito = 0
    var meia = 0
    var total = 0.0


    do{
        println("Digite o nome e a idade do hospede ou 'PARE' para encerrar o cadastro (ex: Naju, 18): ")
        val input = readln().trim()

        //caso o usuario digite PARE, encerra o programa
        if (input.equals("PARE", ignoreCase = true)) break

        //verifica se a pessoa digitou nome e  idade
        if (!input.contains(",") || input.split(",").size != 2) {
            println("Formato inválido! Use: Nome, Idade (ex: Maria, 8)")
            continue
        }

        //separa o nome e a idade (atribue a idade para a variavel idadeStr) com virgula
        val (nomeHospede, idadeStr) = input.split(",").map { it.trim() }

        //verifica se a pessoa digitou
        if (nomeHospede.isBlank() || idadeStr.isBlank()) {
            println("Nome e idade são obrigatórios!")
            continue
        }

        //diz que idade é igual a idadeStr
        val idade = idadeStr.toIntOrNull()

        //verifica se a idade tá no formato certo
        if (idade == null || idade < 0) {
            println("Idade inválida! Digite um número positivo.")
            continue
        }

        //verifica o tipo de pagamento de acordo com a idade
        when{
            idade < 6 -> {
                println("$nomeHospede (${idade} anos) - GRATUIDADE")
                gratuito++
            }
            idade > 60 -> {
                val valorMeia = (diaria / 2) * dias
                println("$nomeHospede (${idade} anos) - PAGA MEIA (R$ ${"%.2f".format(valorMeia)} por $dias dias)")
                total += valorMeia
                meia++
            }
            else -> {
                println("$nomeHospede (${idade} anos) - PAGA INTEIRA (R$ ${"%.2f".format(diaria)} por $dias dias)")
                total += diaria
                meia++
            }
        }

        if (listaHospedes.none { it.equals(nomeHospede, ignoreCase = true) }) {
            listaHospedes.add(nomeHospede)
        }

    }while (true)
    // Resumo final
    println("\n RESUMO HOSPEDAGEM")
    println("Gratuidades: $gratuito; Meias hospedagens: $meia; TOTAL A PAGAR: R$ ${"%.2f".format(total)}")
    println("")

}
fun sairCadastrarFamilia() {
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
            sairCadastrarFamilia()
        }
    }
}

fun erroCadastrarFamilia() {
    println("Por favor, informe um número entre 1 e 3.")
    cadastrarFamiliaHospedes()
}