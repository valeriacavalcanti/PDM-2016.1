//
//  ViewController.swift
//  PokemonGo
//
//  Created by admin on 29/07/16.
//  Copyright © 2016 admin. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
 
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var slVelocidade: UISlider!
    @IBOutlet weak var lbVelocidade: UILabel!
    @IBOutlet weak var swArma: UISwitch!
    @IBOutlet weak var lbNivel: UILabel!
    @IBOutlet weak var stNivel: UIStepper!
    
    let cad = Cadastro()
    
    
    @IBAction func definirVelocidade(sender: AnyObject) {
        self.lbVelocidade.text = String(Int(self.slVelocidade.value))
    }
    
    @IBAction func definirNivel(sender: AnyObject) {
        self.lbNivel.text = String(Int(self.stNivel.value))
    }
    
    @IBAction func salvar(sender: AnyObject) {
        let nome = self.tfNome.text
        let velocidade = Int(self.slVelocidade.value)
        let arma = self.swArma.on
        let nivel = Int(self.stNivel.value)
        
        let p = Pokemon(nome: nome!, velocidade: velocidade, arma: arma, nivel: nivel)
        
        self.cad.add(p)
        
        print("\(nome) - \(velocidade) - \(arma) - \(nivel)")
        print("Quantidade: \(self.cad.quantidade())")
        
    }
    
    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
        self.view.endEditing(true)
    }
}

