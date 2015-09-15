/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietra;

import javax.swing.JOptionPane;

/**
 *
 * @author viniciusfurlanetto
 */
public class Erros {
    
    public void pMostraErro(String psErro, String psTipo) {
        JOptionPane.showMessageDialog(null, psErro, psTipo, JOptionPane.ERROR_MESSAGE);
    }
    public void pMostraAviso(String psErro, String psTipo) {
        JOptionPane.showMessageDialog(null, psErro, psTipo, JOptionPane.INFORMATION_MESSAGE);
    }
}
