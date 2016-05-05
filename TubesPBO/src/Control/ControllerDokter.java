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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hariyanto
 */
public class ControllerDokter implements ActionListener , FocusListener{
    Aplikasi model;
    frameDokter fdok;
    Dokter d;
    DefaultTableModel modeltable;
    
    public ControllerDokter(Aplikasi model){
        this.model = model;
        fdok = new frameDokter();
        fdok.setVisible(true);
        fdok.addListener(this);
        this.d = null;
        viewDataTabel();
        this.fdok.getTfid().addFocusListener(this);
        this.fdok.getTfnama().addFocusListener(this);
        this.fdok.getTfspesial().addFocusListener(this);      
    }
    
    public final void viewDataTabel(){
        Object [][] objek = new Object[model.getALLDokter().size()][3]; 
        int i = 0;
        for (Dokter d: model.getALLDokter()) { 
            String arrayDokter[] = { 
                d.getId(),
                d.getNama(), 
                d.getSpesialisasi()
            };
            objek[i] = arrayDokter; 
            i++;
        }
        modeltable = new DefaultTableModel(objek, fdok.getnamakolom()); 
        fdok.setModel(modeltable);
    }
    
    public void ClearTextField(){ 
        fdok.setid("");
        fdok.setnama("");
        fdok.setspesial("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();  
        try{
        if (source.equals(fdok.getBtnsimpan())) {
            String nama = fdok.getnama();
            String id = fdok.getid();
            String spesialisasi = fdok.getspesial();
            if(d == null){
            if((id.length()==0) || (nama.length() == 0) || (spesialisasi.length()==0)){
                JOptionPane.showMessageDialog(fdok, "field tidak boleh kosong");
            }else{
            model.createDokter(nama,id,spesialisasi);
            }
            }
            viewDataTabel();
            ClearTextField();      
        } else if(source.equals(fdok.getBtnhapus())){
            int row = fdok.getSelectedRow();
            int col = fdok.getSelectedColumn();
            String value = fdok.getValue(row, col);
            model.deleteDataDokter(row,value); 
            viewDataTabel(); 
        } else if(source.equals(fdok.getBtnhome())){
            new ControllerMenu(model);
            fdok.dispose();
        }
        } catch(NullPointerException ee){
            JOptionPane.showMessageDialog(null, "kosong"); 
        }
    
}

    @Override
    public void focusGained(FocusEvent fe) {
      
    }

    @Override
    public void focusLost(FocusEvent fe) {
        Object o = fe.getSource();
        if(o.equals(this.fdok.getTfnama())){
            if(this.fdok.getTfnama().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong"); 
            }
        }
    }
}
