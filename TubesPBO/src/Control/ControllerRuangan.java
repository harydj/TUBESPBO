/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Aplikasi;
import Model.PasienInap;
import Model.Ruangan;
import View.FramePasienInap;
import View.FrameRuangan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hariyanto
 */
public class ControllerRuangan implements ActionListener{
    Aplikasi model;
    FrameRuangan fruang;
    Ruangan r;
    DefaultTableModel modeltable;

    public ControllerRuangan(Aplikasi model) {
        this.model = model;
        fruang = new FrameRuangan();
        fruang.setVisible(true);
        fruang.addListener(this);
        this.r = null;
        viewDataTabel();
        
    }
    
    public final void viewDataTabel(){
        try{
        Object [][] objek = new Object[model.getALLRuangan().size()][2]; 
        int i = 0;
        for (Ruangan r: model.getALLRuangan()) { 
            String arrayRuangan[] = { 
                r.getNoRuang(),
                r.getNama(), 
            };
            objek[i] = arrayRuangan; 
            i++;
        }
        modeltable = new DefaultTableModel(objek, fruang.getnamakolom()); 
        fruang.setModel(modeltable);
        } catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Data masih kosong");
        }
    }

     public void ClearTextField(){ 
        fruang.setNoRuang("");
        fruang.setNama("");


    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource(); 
        if (source.equals(fruang.getBtnsimpan())) {
            String noruang = fruang.getNoRuang();
            String nama = fruang.getNama();

            if(r == null){
            if((noruang.length()==0) || (nama.length() == 0)){
                JOptionPane.showMessageDialog(fruang, "field tidak boleh kosong");
            }else{
            model.createRuangan(noruang,nama);
            }
            viewDataTabel();
            ClearTextField();   
            }
        } else if(source.equals(fruang.getBtnhapus())){
            int row = fruang.getSelectedRow();
            int col = fruang.getSelectedColumn();
            String value = fruang.getValue(row, col);
            model.deleteDataRuangan(row,value); 
            viewDataTabel(); 
        } else if(source.equals(fruang.getBtnhome())){
            new ControllerMenu(model);
            fruang.dispose();
        }
        }
        
}
