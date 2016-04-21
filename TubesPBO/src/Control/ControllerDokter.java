/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Aplikasi;
import Model.Dokter;
import View.frameDokter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author hariyanto
 */
public class ControllerDokter implements ActionListener , FocusListener{
    Aplikasi model;
    frameDokter fdok;
    Dokter d;
    
    public ControllerDokter(Aplikasi model){
        this.model = model;
        fdok = new frameDokter();
        fdok.setVisible(true);
        fdok.addListener(this);
        this.d = null;
        
        this.fdok.getTfid().addFocusListener(this);
        this.fdok.getTfnama().addFocusListener(this);
        this.fdok.getTfspesial().addFocusListener(this);      
    }
    
    public void ClearTextField(){ 
        fdok.setid(fdok.getid());
        fdok.setnama(fdok.getnama());
        fdok.setspesial(fdok.getspesial());
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(fdok.getBtnsimpan())) {
            String nama = fdok.getnama();
            String id = fdok.getid();
            long l = Long.parseLong(id);
            String spesialisasi = fdok.getspesial();
            model.createDokter(nama,l,spesialisasi);
    }
    
}

    @Override
    public void focusGained(FocusEvent fe) {
      
    }

    @Override
    public void focusLost(FocusEvent fe) {
        Object o = fe.getSource();
        if(o.equals(this.fdok.getTfnama()) || o.equals(this.fdok.getTfid()) || o.equals(this.fdok.getTfspesial())){
            if(this.fdok.getTfnama().getText().equals("") || this.fdok.getTfid().getText().equals("") || this.fdok.getTfspesial().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                ClearTextField();
            }
        }
    }
}
