/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ETESP
 */
public class clsImagem {
        
        public clsImagem()
        {
        
        
        }
        public void loadImageToLabel(JLabel lblImagem, String pathFile)
        {        
            File file = new File(pathFile);
            if(file.exists())
            {
                System.out.println("IMAGEM BUSCADA: "+pathFile);
                ImageIcon myImage = new ImageIcon(pathFile); //.getPath, getAbsolutePath ...jLabelImagem1 = new JLabel(new ImageIcon("src//imagem//logo.jpg"));
                Image img = myImage.getImage();
                Image newImg = img.getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH);
                lblImagem.setIcon(new ImageIcon(newImg));
            }
        }   
         
        //retorna o caminho selecionado
        public String openDialogAndLoadImageSelectedToLabel(JLabel lblImagem){
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));//setando o diretiorio a iniciar
        jfc.setFileFilter(new FileNameExtensionFilter("Images file", ImageIO.getReaderFileSuffixes())); //bmp jpg jpeg wbmp png gif
        jfc.setAcceptAllFileFilterUsed(true);//removo o filtro de Todos Arquivos

        //se a caixa de dialogo foi confirmada        
        if(jfc.showOpenDialog(new javax.swing.JPanel()) == JFileChooser.APPROVE_OPTION)
        {
            //pega o arquivo selecionado
            java.io.File f = jfc.getSelectedFile(); 

            loadImageToLabel(lblImagem, f.toString());
            lblImagem.setHorizontalAlignment(javax.swing.JLabel.CENTER);
            
            return f.toString();
        }else
        {
            return null;
        }
    }
}
