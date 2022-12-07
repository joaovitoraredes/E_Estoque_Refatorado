import Menus.*
import Funcionalidade.*
import javax.naming.LimitExceededException

class Deposito {

    private val deposito = mutableListOf <Item>()
    private var id = 1

    init {
        println("${BEM_VINDO.menus}\n${PRINCIPAL.menus}")
        eDeposito()
    }

    private fun eDeposito(){
        do {
            val selecionarOpcao = readln().toInt()

            when(selecionarOpcao) {
                ADICIONAR_ITEM.id -> adicionarItem()
                EDITAR_ITEM.id -> editarItem()
                EXIBIR_TODOS_OS_ITENS.id -> exibirListaCompleta()
                EXIBIR_ITENS_EM_ESTOQUE.id -> exibirListaEmEstoque()
                FINALIZAR_O_PROGRAMA.id -> println("Finalizando programa...")
                else -> println("Entrada inválida, entre com um dos valores abaixo:\n${PRINCIPAL}")
            }
        } while (selecionarOpcao != 0)
    }

     fun adicionarItem() {
        val qtsP: Int

        println("Qual peça você deseja adicionar?")
        val nomeP = readln()

        println("Qual a quantidade?")
        try {
            qtsP = validacaoDaQuantidade()
        } catch (e: LimitExceededException){
            Mensagens().mensagemErroAdiconar()
            Mensagens().voltarMenuErro()
            return
        }

        val peca = Item(id,nomeP,qtsP)
        deposito.add(peca)
        id+=1

        Mensagens().mensagemSucessoAdiconar()
         Mensagens().voltarMenuSucesso()
    }

     fun editarItem(depositoTotal: List <Item> = deposito){

        apenasMostrarLista()

        println("Qual item você deseja editar?")
        val idParaEditar = readln().toInt()

        for (peca in depositoTotal) {

            if (idParaEditar == peca.id) {
                println("#%04d".format(peca.id) + " | ${peca.nome} | ${peca.quantitadeP}")

                println("E oque você deseja editar? (nome/quantidade)")
                when (readln().lowercase()) {
                    "nome" -> {
                        println("Qual o novo nome? ")
                        peca.nome = readln()
                        println("Nome alterado com sucesso")
                        Mensagens().mensagemSucessoEditar()
                        Mensagens().voltarMenuSucessoEdicao()
                    }

                    "quantidade" -> {
                        println("Qual a nova quantidade? ")
                        try {
                            peca.quantitadeP = validacaoDaQuantidade()
                        }   catch (e: LimitExceededException){
                            Mensagens().mensagemErroEditar()
                            Mensagens().voltarMenuErroEdicao()
                            return
                        }
                        Mensagens().mensagemSucessoEditar()
                        Mensagens().voltarMenuSucessoEdicao()
                    }
                }
            }
        }
    }

    fun exibirListaCompleta(pecasExibicao: List <Item> = deposito) {
        println("ID | Peça | Quantidade")
        for (peca in pecasExibicao) {
            println("#%04d".format(peca.id) + " | ${peca.nome} | ${peca.quantitadeP}")
        }
         Mensagens().voltarMenuListaC()
    }

    fun exibirListaEmEstoque(pecasExibicao: List <Item> = deposito) {
        println("ID | Peça | Quantidade")
        for (peca in pecasExibicao) {
            if (peca.quantitadeP > 0)
                println("#%04d".format(peca.id) + " | ${peca.nome} | ${peca.quantitadeP}")
        }
         Mensagens().voltarMenuListaE()
    }

    private fun validacaoDaQuantidade():Int{
        val quantidade = try {
            readln().toInt()
        } catch (e: NumberFormatException)
        { null }
        if (quantidade == null || quantidade > 999 || quantidade < 0){
            throw LimitExceededException(null)
        }
        return quantidade
    }

     private fun apenasMostrarLista(pecasExibicao: List <Item> = deposito) {
        println("ID | Peça | Quantidade")
        for (peca in pecasExibicao) {
            println("#%04d".format(peca.id) + " | ${peca.nome} | ${peca.quantitadeP}")
        }
    }
}



