//
//  Pokemon.swift
//  PokemonGo
//
//  Created by admin on 29/07/16.
//  Copyright © 2016 admin. All rights reserved.
//

import Foundation

class Pokemon: NSObject {
    var nome: String!
    var velocidade: Int!
    var arma: Bool!
    var nivel: Int!
    
    init(nome:String, velocidade: Int, arma: Bool, nivel: Int) {
        self.nome = nome
        self.velocidade = velocidade
        self.arma = arma
        self.nivel = nivel
    }
    
}