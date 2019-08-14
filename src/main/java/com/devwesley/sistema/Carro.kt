package com.devwesley.sistema

class Pessoa (var nome:String, var senha:String){

    init{
        this.nome = nome
        this.senha = senha
    }
    override fun toString() = "Usuario: $nome   Senha: ($senha)"
}