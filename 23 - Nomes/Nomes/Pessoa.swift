//
//  Pessoa.swift
//  Nomes
//
//  Created by admin on 23/08/16.
//  Copyright © 2016 admin. All rights reserved.
//

import Foundation

class Pessoa: NSObject, NSCoding {
    var nome:String!
    
    override var description: String{
        return self.nome
    }
    
    init(nome:String) {
        self.nome = nome
    }
    
    required init?(coder aDecoder: NSCoder) {
        self.nome = aDecoder.decodeObjectForKey("nome") as! String
    }
    
    func encodeWithCoder(aCoder: NSCoder) {
        aCoder.encodeObject(self.nome, forKey: "nome")
    }
}