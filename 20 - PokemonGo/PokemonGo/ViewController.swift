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
    
    var delegate: ListarTableViewController!
    
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
        
        self.delegate.addPokemon(p)
        //self.cad.add(p)
        
        print("\(nome) - \(velocidade) - \(arma) - \(nivel)")
        //print("Quantidade: \(self.cad.quantidade())")
        
        self.navigationController?.popViewControllerAnimated(true)
    }
    /*
    
    @IBAction func exibirsobre(sender: AnyObject) {
        if (self.sobreVC == nil){
            self.sobreVC = self.storyboard?.instantiateViewControllerWithIdentifier("sobre") as! SobreViewController
        }
        
        self.sobreVC.quantidade = self.cad.quantidade()
        
        self.presentViewController(self.sobreVC, animated: true, completion: nil)
    }
    */
    
    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
        self.view.endEditing(true)
    }
}

