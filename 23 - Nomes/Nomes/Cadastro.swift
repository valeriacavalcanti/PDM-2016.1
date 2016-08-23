//
//  Cadastro.swift
//  Nomes
//
//  Created by admin on 23/08/16.
//  Copyright © 2016 admin. All rights reserved.
//

import Foundation

class Cadastro: NSObject, NSCoding {
    var lista: Array<Pessoa>!
    
    override init() {
        self.lista = Array<Pessoa>()
    }
    
    required init?(coder aDecoder: NSCoder) {
        self.lista = aDecoder.decodeObjectForKey("lista") as! Array<Pessoa>
    }
    
    func encodeWithCoder(aCoder: NSCoder) {
        aCoder.encodeObject(self.lista, forKey: "lista")
    }
    
    func add(p:Pessoa) {
        self.lista.append(p)
    }
    
    func quantidade() -> Int {
        return self.lista.count
    }
    
    func get(index:Int) -> Pessoa {
        return self.lista[index]
    }
}