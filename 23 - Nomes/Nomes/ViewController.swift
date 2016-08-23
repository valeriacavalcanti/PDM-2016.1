//
//  ViewController.swift
//  Nomes
//
//  Created by admin on 23/08/16.
//  Copyright © 2016 admin. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {

    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var tvPessoas: UITableView!
    
    var cadastro = Cadastro()
    
    func path() -> String {
        return NSSearchPathForDirectoriesInDomains(NSSearchPathDirectory.DocumentDirectory, NSSearchPathDomainMask.UserDomainMask, true)[0]
    }
    
    func arquivo() -> String {
        return "\(self.path())/arquivo"
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.tvPessoas.dataSource = self
        self.tvPessoas.delegate = self
        
        let obj = NSKeyedUnarchiver.unarchiveObjectWithFile(self.arquivo())
        if (obj != nil){
            self.cadastro = obj as! Cadastro
        }else{
            self.cadastro = Cadastro()
        }
    }
    
    override func viewWillDisappear(animated: Bool) {
        super.viewWillDisappear(true)
        
        NSKeyedArchiver.archiveRootObject(self.cadastro, toFile: self.arquivo())
    }

    @IBAction func salvar(sender: AnyObject) {
        let nome = self.tfNome.text
        let p = Pessoa(nome: nome!)
        self.cadastro.add(p)
        self.tvPessoas.reloadData()
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1;
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.cadastro.quantidade()
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell = self.tvPessoas.dequeueReusableCellWithIdentifier("celula")
        
        cell?.textLabel?.text = self.cadastro.get(indexPath.row).nome
        
        return cell!;
    }
}

