/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Formularios.principal;
import com.birosoft.liquid.LiquidLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author hp
 */
public class Lp2_ff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel"); //skin
            LiquidLookAndFeel.setLiquidDecorations(true, "");//
            new principal().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Lp2_ff.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    }
    

