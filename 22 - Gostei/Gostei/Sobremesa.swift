//
//  Sobremesa.swift
//  Gostei
//
//  Created by admin on 16/08/16.
//  Copyright © 2016 admin. All rights reserved.
//

import Foundation

class Sobremesa: NSObject {
    var nome:String!
    
    override var description: String{
        return self.nome
    }
    
    init (nome:String){
        self.nome = nome
    }
}