//
//  ViewController.swift
//  Gostei
//
//  Created by admin on 16/08/16.
//  Copyright © 2016 admin. All rights reserved.
//

import UIKit

class FormularioViewController: UIViewController {
    
    var delegate: ListarTableViewController!

    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.navigationItem.rightBarButtonItem = UIBarButtonItem(barButtonSystemItem: UIBarButtonSystemItem.Save, target: self, action: #selector(salvar))
    }
    
    func salvar() {
        print("Funfou")
        self.delegate.salvar(Sobremesa(nome: "teste"))
        self.navigationController?.popViewControllerAnimated(true)
    }

}

