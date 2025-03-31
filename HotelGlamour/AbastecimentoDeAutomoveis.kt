package HotelGlamour

fun abastecimentoDeImoveis() {

    println("Bem-vindo ao $hotel, faça o abastecimento de imóveis!")
    posto()

}

fun lerValorPositivo(mensagem: String): Double {
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

fun posto(){
    println("\nComparação de preços entre postos")

    // Wayne Oil
    val alcoolWayne = lerValorPositivo("Qual o valor do álcool no posto Wayne Oil?")
    val gasolinaWayne = lerValorPositivo("Qual o valor da gasolina no posto Wayne Oil?")

    // Stark Petrol
    val alcoolStark = lerValorPositivo("Qual o valor do álcool no posto Stark Petrol?")
    val gasolinaStark = lerValorPositivo("Qual o valor da gasolina no posto Stark Petrol?")

    //verifica o custo de gasolina e alcoool de cada posto
    val custoAlcoolWayne = 42 * alcoolWayne
    val custoGasolinaWayne = 42 * gasolinaWayne
    val custoAlcoolStark = 42 * alcoolStark
    val custoGasolinaStark = 42 * gasolinaStark

    //verica o alcool é mais vantajoso que a gasolina
    val alcoolVantajosoWayne = alcoolWayne <= gasolinaWayne * 0.7
    val alcoolVantajosoStark = alcoolStark <= gasolinaStark * 0.7

    //verifica a melhor opção de cada posto
    val melhorWayne = if (alcoolVantajosoWayne && custoAlcoolWayne < custoGasolinaWayne) {
        "álcool"
    } else {
        "gasolina"
    }
    val melhorStark = if (alcoolVantajosoStark && custoAlcoolStark < custoGasolinaStark) {
        "álcool"
    } else {
        "gasolina"
    }

    //mostra o custo final de cada posto
    val custoFinalWayne = if (melhorWayne == "álcool") custoAlcoolWayne else custoGasolinaWayne
    val custoFinalStark = if (melhorStark == "álcool") custoAlcoolStark else custoGasolinaStark

    //verifica qual posto tem melhor preço
    val (posto, combustivel) = when {
        custoFinalWayne < custoFinalStark -> Pair("Wayne Oil", melhorWayne)
        custoFinalStark < custoFinalWayne -> Pair("Stark Petrol", melhorStark)
        else -> Pair("ambos", "igual preço")
    }

    //exibe o resultado final, com melhor posto e combustível
    println("\nResultado:")
    if (posto == "ambos") {
        println("Os dois postos têm o mesmo preço para abastecer.")
    } else {
        println("É mais barato abastecer com $combustivel no posto $posto.")
    }

}