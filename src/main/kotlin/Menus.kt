enum class Menus(val menus: String){
    BEM_VINDO("""
    ========= Bem Vindo ==========
    """.trimIndent()),

    PRINCIPAL("""
        1...............ADICIONAR ITEM
        2..................EDITAR ITEM
        3........EXIBIR TODOS OS ITENS
        4......EXIBIR ITENS EM ESTOQUE
        0.............FECHAR O SISTEMA
    """.trimIndent())

}