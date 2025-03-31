package HotelGlamour

fun arCondicionado() {

    println("Bem-vindo ao $hotel, faça a manutenção dos ar condicionados!")
    manutencao()

}

fun valorDoublePositivo(mensagem: String): Double {
    while (true) {
        println(mensagem)
        val input = readln().trim()
        when {
            input.isBlank() -> println("Valor não pode ser vazio! Digite novamente:")
            else -> {
                val valor = input.toDoubleOrNull() ?: 0.0
                if (valor > 0) return valor
                println("Valor inválido! Digite um número positivo:")
            }
        }
    }
}

fun valorIntPositivo(mensagem: String): Double {
    while (true) {
        println(mensagem)
        val input = readln().trim()
        when {
            input.isBlank() -> println("Valor não pode ser vazio! Digite novamente:")
            else -> {
                val valor = input.toDoubleOrNull() ?: 0.0
                if (valor > 0) return valor
                println("Valor inválido! Digite um número positivo:")
            }
        }
    }
}

fun manutencao() {
    val orcamentos = mutableListOf<Pair<String, Double>>()

    do {
        println("\nManutenção de aparelhos")

        val valorServico = valorDoublePositivo("Qual o valor do serviço?")
        val qtde = valorIntPositivo("Qual a quantidade de aparelhos?")
        val percentual = valorIntPositivo("Qual o percentual de desconto (pode ser 0)?")
        val minQtde = valorIntPositivo("Qual a quantidade minima de aparelhos?")

        val totalServico = qtde * valorServico

        val totalDesconto = if (qtde > minQtde) {
            totalServico * (1 - percentual / 100.0)
        } else {
            totalServico
        }

        println("Cadastro de Hóspedes.\nPor favor, informe o nome da empresa:")
        var nomeEmpresa: String
        while (true) {
            nomeEmpresa = readln().trim()
            if (nomeEmpresa.isBlank()) {
                println("Nome não pode ser vazio! Digite o nome do hóspede:")
                continue
            }
            break
        }

        println("O serviço de $nomeEmpresa custará R$ %.2f".format(totalDesconto))

        //adiciona o nome da empresa e o orçamento com desconto
        orcamentos.add(nomeEmpresa to totalDesconto)

        //pergunta pro usuario se ele quer informar novos dados
        var continuar: String
        while (true) {
            println("Deseja informar novos dados? (S/N)")
            continuar = readln().trim().uppercase()
            if (continuar == "S" || continuar == "N") break
            println("Opção inválida! Digite S ou N.")
        }
        if (continuar == "N") break

    } while (true)

    //verifica se há orçamentos cadastrados
    if (orcamentos.isNotEmpty()) {
        val menorOrcamento = orcamentos.minByOrNull { it.second } //verifica o menor valor (orçamento)
        //acessa o nome da empresa
        println(("\nO orçamento de menor valor é o de ${menorOrcamento?.first}" +
        //acessa o orçamento
                " por R$ %.2f").format(menorOrcamento?.second))
    }
}