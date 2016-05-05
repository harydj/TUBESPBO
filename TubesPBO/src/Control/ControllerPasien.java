/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Aplikasi;
import Model.Dokter;
import Model.Pasien;
import View.framePasien;
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
public class ControllerPasien implements ActionListener , FocusListener{
    Aplikasi model;
    framePasien fpas;
    Pasien p;
    DefaultTableModel modeltable;
    
     public ControllerPasien(Aplikasi model){
        this.model = model;
        fpas = new framePasien();
        fpas.setVisible(true);
        fpas.addListener(this);
        this.p = null;
        viewDataTabel();
        
        this.fpas.getTfid().addFocusListener(this);
        this.fpas.getTfnama().addFocusListener(this);
        this.fpas.getTfalamat().addFocusListener(this);      
        this.fpas.getTfkeluhan().addFocusListener(this);  
    }
     
     public final void viewDataTabel(){
        Object [][] objek = new Object[model.getALLPasien().size()][4]; 
        int i = 0;
        for (Pasien p: model.getALLPasien()) { 
            String arrayPasien[] = { 
                p.getId(),
                p.getNama(), 
                p.getAlamat(),
                p.getKeluhan(),
            };
            objek[i] = arrayPasien; 
            i++;
        }
        modeltable = new DefaultTableModel(objek, fpas.getnamakolom()); 
        fpas.setModel(modeltable);
    }

     public void ClearTextField(){ 
        fpas.setid("");
        fpas.setnama("");
        fpas.setalamat("");
        fpas.setkeluhan("");
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();  
        try{
        if (source.equals(fpas.getBtnsimpan())) {
            String nama = fpas.getnama();
            String id = fpas.getid();
            String alamat = fpas.getalamat();
            String keluhan = fpas.getKeluhan();
            if(p == null){
            if((id.length()==0) || (nama.length() == 0) || (alamat.length()==0)){
                JOptionPane.showMessageDialog(fpas, "field tidak boleh kosong");
            }else{
                model.createPasien(nama,id,alamat,keluhan);
            }
            }
            viewDataTabel();
            ClearTextField();      
        } else if(source.equals(fpas.getBtnhapus())){
            int row = fpas.getSelectedRow();
            int col = fpas.getSelectedColumn();
            String value = fpas.getValue(row, col);
            model.deleteDataPasien(row,value); 
            viewDataTabel(); 
        } else if(source.equals(fpas.getBtnhome())){
            new ControllerMenu(model);
            fpas.dispose();
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
        if(o.equals(this.fpas.getTfnama())){
            if(this.fpas.getTfnama().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong"); 
            }
      
    }
    }

   
    
}
