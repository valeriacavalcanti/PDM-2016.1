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
    
    var sobreVC: SobreViewController!
    
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
        
        let alert = UIAlertController(title: "Atenção", message: "Pokemon cadastrado com sucesso!", preferredStyle: UIAlertControllerStyle.Alert)
        alert.addAction(UIAlertAction(title: "Ok", style: UIAlertActionStyle.Default, handler: nil))
        
        self.presentViewController(alert, animated: true, completion: nil)
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
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if (segue.identifier == "cadastro_sobre"){
            let view = segue.destinationViewController as! SobreViewController
            view.quantidade = self.cad.quantidade()
        }
    }
    
    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
        self.view.endEditing(true)
    }
}

