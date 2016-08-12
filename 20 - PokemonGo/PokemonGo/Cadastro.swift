//
//  Cadastro.swift
//  PokemonGo
//
//  Created by admin on 29/07/16.
//  Copyright © 2016 admin. All rights reserved.
//

import Foundation

class Cadastro: NSObject {
    var lista: Array<Pokemon>!
    
    override init() {
        self.lista = Array<Pokemon>()
    }
    
    func add(p: Pokemon) {
        self.lista.append(p)
    }
    
    func quantidade() -> Int {
        return self.lista.count
    }
    
    func get(index:Int) -> Pokemon{
        return self.lista[index]
    }
    
    func del(index:Int){
        self.lista.removeAtIndex(index)
    }
}