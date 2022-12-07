import Menus.*
class Mensagens {
    fun mensagemErroAdiconar(){
        println("Item não adicionado - Quantidade inválida!! \n" +
                "Voltar ao menu principal? (S/N)")
    }
    fun mensagemErroEditar(){
        println("Item não editado - Quantidade inválida!! \n" +
                "Voltar ao menu principal? (S/N)")
    }
    fun mensagemSucessoAdiconar(){
        println("Item adicionado!! \n" + "Voltar ao menu principal? (S/N)")
    }
    fun mensagemSucessoEditar() {
        println("Item editado!! \n" + "Voltar ao menu principal? (S/N)")
    }
    fun voltarMenuListaC(){
        println("Voltar ao menu principal? (S/N)")
        when(readln().uppercase()){
            "S" -> println(PRINCIPAL.menus)
            "N" -> Deposito().exibirListaCompleta()
            else -> {
                println("Entrada inválida!! \nVoltar ao menu principal? (S/N)")
                voltarMenuListaC()
            }
        }
    }
    fun voltarMenuListaE(){
        println("Voltar ao menu principal? (S/N)")
        when(readln().uppercase()){
            "S" -> println(PRINCIPAL.menus)
            "N" -> Deposito().exibirListaEmEstoque()
            else -> {
                println("Entrada inválida!! \nVoltar ao menu principal? (S/N)")
                voltarMenuListaE()
            }
        }
    }
    fun voltarMenuErro(){
        when(readln().uppercase()){
            "S" -> println(PRINCIPAL.menus)
            "N" ->Deposito().adicionarItem()
            else -> {
                println("Entrada inválida!! \nVoltar ao menu principal? (S/N)")
                voltarMenuErro()
            }
        }
    }
    fun voltarMenuErroEdicao(){
        when(readln().uppercase()){
            "S" -> println(PRINCIPAL.menus)
            "N" -> Deposito().editarItem()
            else -> {
                println("Entrada inválida!! \nVoltar ao menu principal? (S/N)")
                voltarMenuErroEdicao()
            }
        }
    }
    fun voltarMenuSucesso(){
        when(readln().uppercase()){
            "S" -> println(PRINCIPAL.menus)
            "N" -> Deposito().adicionarItem()
            else -> {
                println("Entrada inválida!! \nVoltar ao menu principal? (S/N)")
                voltarMenuErro()
            }
        }
    }
    fun voltarMenuSucessoEdicao(){
        when(readln().uppercase()){
            "S" -> println(PRINCIPAL.menus)
            "N" -> Deposito().editarItem()
            else -> {
                println("Entrada inválida!! \nVoltar ao menu principal? (S/N)")
                voltarMenuErro()
            }
        }
    }
}