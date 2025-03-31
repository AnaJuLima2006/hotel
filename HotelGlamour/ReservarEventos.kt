package HotelGlamour

import kotlin.system.exitProcess



fun reservarEventos() {

    println("Bem-vindo ao $hotel, faça de reserva de evento!")
    localEvento()

}


fun solicitarQtdeConvidados(): Int {
    while (true) {
        println("Por favor, informe o número de convidados para o evento:")
        val input = readln().trim()

        when {
            input.isBlank() -> {
                println("Convidados não pode ser vazio!")
                continue
            }
            else -> {
                val convidados = input.toIntOrNull() ?: 0
                when {
                    convidados <= 0 -> println("Número de convidados não pode ser negativo ou zero!")
                    convidados > 350 -> println("Quantidade superior à capacidade máxima (350)!")
                    else -> return convidados  // Retorna somente quando for válido
                }
            }
        }
    }
}

fun localEvento() {
    val convidados = solicitarQtdeConvidados()
    val capacidadeLaranja = 150
    val cadeirasAdicionaisMax = 70
    val capacidadeColorado = 350

    when {
        convidados <= capacidadeLaranja -> {
            println("Auditório Laranja é o mais adequado")
            println("Não serão necessárias cadeiras adicionais")
            dataEvento()
        }
        convidados <= (capacidadeLaranja + cadeirasAdicionaisMax) -> {
            val cadeirasAdicionais = convidados - capacidadeLaranja
            println("Auditório Laranja é o mais adequado")
            println("Serão necessárias $cadeirasAdicionais cadeiras adicionais")
            dataEvento()
        }
        else -> {
            println("Auditório Colorado é o mais adequado")
            dataEvento()
        }

    }
}

fun dataEvento() {

    val diasDaSemana = listOf("Segunda", "Terça", "Quarta", "Quinta", "Sexta")
    val fimDeSemana = listOf("Sábado", "Domingo")

    var semana: String
    while (true) {
        println("Qual o dia da semana?")
        semana = readln().trim()

        if (semana.isBlank()) {
            println("Dia da semana não pode ser vazio!")
            continue
        }

        // Verifica se o dia é válido
        if (diasDaSemana.none { it.equals(semana, ignoreCase = true) } &&
            fimDeSemana.none { it.equals(semana, ignoreCase = true) }) {
            println("Dia da semana inválido! Digite um dia válido.")
            continue
        }

        break
    }

    println(
        "   Qual o horário?\n" +
        "   Segunda á sexta: 7h á 23h\n" +
        "   Sábado e Domingo: 7h ás 15h"
    )
    var hora: Int
    while (true) {
        val input = readln().trim()
        if (input.isBlank()) {
            println("Hora não pode ser vazio! Digite o horário:")
            continue
        }
        hora = input.toIntOrNull() ?: 0

        when {
            diasDaSemana.any { it.equals(semana, ignoreCase = true) } -> {
                if (hora < 7 || hora >= 23) {
                    println("Horário inválido para dia de semana! Digite entre 7h e 23h:")
                    continue
                }
                break
            }
            fimDeSemana.any { it.equals(semana, ignoreCase = true) } -> {
                if (hora < 7 || hora >= 15) {
                    println("Horário inválido para fim de semana! Digite entre 7h e 15h:")
                    continue
                }
                break
            }
            else -> {
                println("Dia da semana inválido! Digite um dia válido:")
                semana = readln().trim()
                continue
            }
        }

    }

    when {
        diasDaSemana.any { it.equals(semana, ignoreCase = true) } ||
                fimDeSemana.any { it.equals(semana, ignoreCase = true) } -> {
            println("Qual o nome da empresa?")
            var empresa = readln().trim()
            while (empresa.isBlank()) {
                println("Nome da empresa não pode ser vazio! Digite o nome da empresa:")
                empresa = readln().trim()
            }
            println("Auditório disponível para $semana às ${hora}h, para $empresa")
            funcionariosEvento()
        }
    }
}

fun funcionariosEvento(){

    val valorGarcomH = 10.50

    println("\nContratação de garçons")


    // solicita a qtde de convidados e verifica se é vazio ou se o número é válido
    var convidados = 0
    while (true) {
        println("Quantos convidados estão confirmados para o evento?")
        val input = readln().trim()

        if (input.isBlank()) {
            println("Você não digitou nada. Por favor, informe um número!")
            continue
        }

        convidados = input.toIntOrNull() ?: 0
        if (convidados > 0) break
        println("Número inválido! Digite um valor maior que zero.")
    }

    // solicita a hora e verifica se é vazio ou se o número é válido
    var horasEvento = 0
    while (true) {
        println("Qual a duração total do evento em horas?")
        val input = readln().trim()

        if (input.isBlank()) {
            println("Você não digitou nada. Por favor, informe um número!")
            continue
        }

        horasEvento = input.toIntOrNull() ?: 0
        if (horasEvento > 0) break
        println("Número inválido! Digite um valor maior que zero.")
    }

    //calcula a qtde de garçons necessários para cada 12 convidados
    val garconsPorConvidados = kotlin.math.ceil(convidados / 12.0).toInt()

    //calcula a qtde de garçons adicionais
    val garconsPorHoras = kotlin.math.ceil(horasEvento / 2.0).toInt()

    //calcula  a qtde total de garçons
    val totalGarcons = garconsPorConvidados + garconsPorHoras

    //calcula o custo todal com os garçons
    val custoTotal = totalGarcons * horasEvento * valorGarcomH

    println("\n Resumo de contratação ")
    println("Garçons por convidados: $garconsPorConvidados (1 para cada 12 convidados)")
    println("Garçons adicionais á cada 2 horas: $garconsPorHoras (1 adicional a cada 2 horas)")
    println("Total de garçons contratados: $totalGarcons")
    println("Custo total com garçons: R$ ${"%.2f".format(custoTotal)}")

    buffetEvento()
}

fun buffetEvento(){
    println("\n Buffet do evento ")

    // solicita quantidade de convidados
    println("Quantos convidados estão confirmados para o buffet?")
    val convidados = readln().toIntOrNull() ?: 0


    if (convidados <= 0) {
        println("Número de convidados inválido!")
        return
    }

    // calcula as quantidades
    val cafeLitros = convidados * 0.2
    val aguaLitros = convidados * 0.5
    val salgadosUnidades = convidados * 7

    //preço das comidas
    val precoCafe = 0.80
    val precoAgua = 0.40
    val precoSalgados = 34.00 // por cento (100 unidades)

    // calcula os custos
    val custoCafe = cafeLitros * precoCafe
    val custoAgua = aguaLitros * precoAgua
    val custoSalgados = (salgadosUnidades / 100.0) * precoSalgados
    val custoTotal = custoCafe + custoAgua + custoSalgados

    // exibição dos resultados
    println("\n Quantidades necessárias ")
    println("Café: ${"%.1f".format(cafeLitros)} litros")
    println("Água: ${"%.1f".format(aguaLitros)} litros")
    println("Salgados: $salgadosUnidades unidades (${salgadosUnidades / 100} centos)")

    println("\n Custo do buffet")
    println("Café: R$ ${"%.2f".format(custoCafe)}")
    println("Água: R$ ${"%.2f".format(custoAgua)}")
    println("Salgados: R$ ${"%.2f".format(custoSalgados)}")
    println("TOTAL: R$ ${"%.2f".format(custoTotal)}")
    sairEventos()
}

fun sairEventos() {
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
            sairEventos()
        }
    }
}





