/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Aplikasi;
import Model.Pasien;
import Model.PasienInap;
import View.FramePasienInap;
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
public class ControllerPasienInap implements ActionListener , FocusListener{
    Aplikasi model;
    FramePasienInap fpasi;
    PasienInap pi;
    DefaultTableModel modeltable;
    
    public ControllerPasienInap(Aplikasi model){
        this.model = model;
        fpasi = new FramePasienInap();
        fpasi.setVisible(true);
        fpasi.addListener(this);
        this.pi = null;
        viewDataTabel();
        
        this.fpasi.getTfidpas().addFocusListener(this);
        this.fpasi.getTfiddok().addFocusListener(this);
        this.fpasi.getTfdiagnosa().addFocusListener(this);      
 
    }
     
     public final void viewDataTabel(){
        try{
        Object [][] objek = new Object[model.getALLPasienInap().size()][3]; 
        int i = 0;
        for (PasienInap pi: model.getALLPasienInap()) { 
            String arrayPasienInap[] = { 
                pi.getIdpas(),
                pi.getIddok(), 
                pi.getDiagnosa(),
            };
            objek[i] = arrayPasienInap; 
            i++;
        }
        modeltable = new DefaultTableModel(objek, fpasi.getnamakolom()); 
        fpasi.setModel(modeltable);
        } catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Data masih kosong");
        }
    }

     public void ClearTextField(){ 
        fpasi.setidpas("");
        fpasi.setiddok("");
        fpasi.setdiagnosa("");

    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();  
        if (source.equals(fpasi.getBtnsimpan())) {
            String idpas = fpasi.getidpas();
            String iddok = fpasi.getiddok();
            String diagnosa = fpasi.getdiagnosa();
            try{
            if(pi == null){
            if((idpas.length()==0) || (iddok.length() == 0) || (diagnosa.length()==0)){
                JOptionPane.showMessageDialog(fpasi, "field tidak boleh kosong");
            }else{
            model.createPasienInap(idpas,iddok,diagnosa);
            }
            }
            }catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, "Isi semua field yang ada");
            
            }
            viewDataTabel();
            ClearTextField();      
        } else if(source.equals(fpasi.getBtnhapus())){
            int row = fpasi.getSelectedRow();
            int col = fpasi.getSelectedColumn();
            String value = fpasi.getValue(row, col);
            model.deleteDataPasienInap(row,value); 
            viewDataTabel(); 
        } else if(source.equals(fpasi.getBtnhome())){
            new ControllerMenu(model);
            fpasi.dispose();
        }

    }

    @Override
    public void focusGained(FocusEvent fe) {
        
    }

    @Override
    public void focusLost(FocusEvent fe) {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
