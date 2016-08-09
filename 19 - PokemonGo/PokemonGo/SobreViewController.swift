//
//  SobreViewController.swift
//  PokemonGo
//
//  Created by admin on 02/08/16.
//  Copyright © 2016 admin. All rights reserved.
//

import UIKit

class SobreViewController: UIViewController {
    var quantidade:Int!
    
    @IBOutlet weak var lbQuantidade: UILabel!
    

    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
        self.dismissViewControllerAnimated(true, completion: nil)
    }
    
    /*
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.lbQuantidade.text = String(self.quantidade)
    }
 
    
    override func viewDidAppear(animated: Bool) {
        super.viewDidAppear(true)
        self.lbQuantidade.text = String(self.quantidade)
    }
     */
    
    override func viewWillAppear(animated: Bool) {
        super.viewWillAppear(true)
        self.lbQuantidade.text = String(self.quantidade)
    }
    
}
