/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Aplikasi;
import View.frameMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hariyanto
 */
public class ControllerMenu implements ActionListener{
    Aplikasi model;
    frameMenu mainmenu;
    
    public ControllerMenu(Aplikasi model){
        this.model = model;
        mainmenu = new frameMenu();
        mainmenu.setVisible(true);
        mainmenu.addListener(this);        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(mainmenu.getBtndok())) {
            new ControllerDokter(model);
            mainmenu.dispose();
        } else if(source.equals(mainmenu.getBtnp())) {
            new ControllerPasien(model);
            mainmenu.dispose();
        }else if(source.equals(mainmenu.getBtnpi())) {
            new ControllerPasienInap(model);
            mainmenu.dispose();
        }else if(source.equals(mainmenu.getBtnr())) {
            new ControllerRuangan(model);
            mainmenu.dispose();
        }else if(source.equals(mainmenu.getBtnexit())) {
            mainmenu.dispose();
        }
    }
}
