package HotelGlamour

val quartos = MutableList(20) { false }

fun cadastrarQuartos() {


    while (true) {
        println("""Cadastro de Quartos
        Selecione uma opção:
        1. Cadastrar diaria
        2. Pesquisar
        3. Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarDiaria()

        }
    }
}

fun cadastrarDiaria(){


}
