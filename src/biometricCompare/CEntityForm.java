package biometricCompare;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import Biometrics.CFingerPrint;
import Biometrics.CFingerPrintGraphics;
import accessControl.ClUser;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.lang.Exception ;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;



public class CEntityForm extends JFrame {

  class BJPanel extends JPanel 
  {
    public BufferedImage bi;
    public BJPanel (){
        this.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent m){
        JOptionPane.showMessageDialog (null,"("+Integer.toString(m.getPoint().x)+";"+Integer.toString(m.getPoint().y)+")","Point",JOptionPane.PLAIN_MESSAGE);
        }
        });
    }
    public BJPanel (BufferedImage bi){
      this.bi = bi;
      setPreferredSize(new Dimension(bi.getWidth(),bi.getHeight())) ;
    }
    public void setBufferedImage(BufferedImage bi)
    {
      this.bi = bi;
      setPreferredSize(new Dimension(bi.getWidth(),bi.getHeight())) ;
      this.repaint();
    }
    public void paintComponent(Graphics g)
    {
      g.drawImage(bi,0,0,this) ;
    }
  }

  private JToolBar jtool = new JToolBar();
  private JPanel jimage = new JPanel();
  private JButton jButtonStep1 = new JButton("Calculation");
  private JButton jButtonStep2 = new JButton("Image Processing");
  private JButton jButtonStep3 = new JButton("1 to 1 Match");
  private JButton jButtonStep4 = new JButton("1 to m Match");
  private JTextField jTextField1 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  
  //uses our finger print libery
  private CFingerPrint m_finger1 = new CFingerPrint();
  private CFingerPrint m_finger2 = new CFingerPrint();
  private CFingerPrintGraphics m_fingergfx = new CFingerPrintGraphics();
  private BJPanel m_panel1 = new BJPanel();
  private BJPanel m_panel2 = new BJPanel();
  private BufferedImage m_bimage1 = new BufferedImage(m_finger1.FP_IMAGE_WIDTH ,m_finger1.FP_IMAGE_HEIGHT,BufferedImage.TYPE_INT_RGB );
  private BufferedImage m_bimage2 = new BufferedImage(m_finger2.FP_IMAGE_WIDTH ,m_finger2.FP_IMAGE_HEIGHT,BufferedImage.TYPE_INT_RGB );
  private double finger1[] = new double[m_finger1.FP_TEMPLATE_MAX_SIZE];
  private double finger2[] = new double[m_finger2.FP_TEMPLATE_MAX_SIZE];
  
  //New
  private ArrayList<CFingerPrint> m_finger=new ArrayList<CFingerPrint>();
  private ArrayList<BufferedImage> m_bimage=new ArrayList<BufferedImage>();
  private ArrayList<double[]> finger=new ArrayList<double[]>();
  private ArrayList<ClUser> userList=new ArrayList<ClUser>();
  public CEntityForm() {
   jButtonStep1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButtonStep1_actionPerformed(e);
      }
    });
    jButtonStep2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButtonStep2_actionPerformed(e);
      }
    });
    jButtonStep3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButtonStep3_actionPerformed(e);
      }
    });
    jButtonStep4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButtonStep4_actionPerformed(e);
      }
    });

    jtool.setLayout(new GridLayout(4,1));
    jtool.add(jButtonStep1);
    jtool.add(jButtonStep2);
    jtool.add(jButtonStep3);
    jtool.add(jButtonStep4);
    jtool.add(jTextField1);
    jtool.add(jTextField2);
    prep();      
    this.getContentPane().setLayout(new GridLayout(2,2));
    this.getContentPane().add(m_panel1);
    this.getContentPane().add(m_panel2);
    this.getContentPane().add(jtool);
   
    this.setTitle("Entity");
    this.setSize(new Dimension(900, 700)) ;
  }

  private void prep(){
    BufferedImage tempImg;
    CFingerPrint tempFing;
    double[] tempFinger;
      try
    {     
       tempFing= new CFingerPrint();
       tempImg=new BufferedImage(tempFing.FP_IMAGE_WIDTH ,tempFing.FP_IMAGE_HEIGHT,BufferedImage.TYPE_INT_RGB );
       tempImg=ImageIO.read(new File("C:\\Users\\kanchanaR\\Documents\\NetBeansProjects\\BiometricsTest\\build\\classes\\Sample2.bmp")) ;
       tempFing.setFingerPrintImage(tempImg);
       tempFinger=tempFing.getFingerPrintTemplate();
       tempImg=tempFing.getFingerPrintImageDetail();
       m_finger.add(tempFing);
       m_bimage.add(tempImg);
       finger.add(tempFinger);
       
       tempFing= new CFingerPrint();
       tempImg=new BufferedImage(tempFing.FP_IMAGE_WIDTH ,tempFing.FP_IMAGE_HEIGHT,BufferedImage.TYPE_INT_RGB );
       tempImg=ImageIO.read(new File("C:\\Users\\kanchanaR\\Documents\\NetBeansProjects\\BiometricsTest\\build\\classes\\Sample5.bmp")) ;
       tempFing.setFingerPrintImage(tempImg);
       tempFinger=tempFing.getFingerPrintTemplate();
       tempImg=tempFing.getFingerPrintImageDetail();
       m_finger.add(tempFing);
       m_bimage.add(tempImg);
       finger.add(tempFinger);
       
       tempFing= new CFingerPrint();
       tempImg=new BufferedImage(tempFing.FP_IMAGE_WIDTH ,tempFing.FP_IMAGE_HEIGHT,BufferedImage.TYPE_INT_RGB );
       tempImg=ImageIO.read(new File("C:\\Users\\kanchanaR\\Documents\\NetBeansProjects\\BiometricsTest\\build\\classes\\Sample3.bmp")) ;
       tempFing.setFingerPrintImage(tempImg);
       tempFinger=tempFing.getFingerPrintTemplate();
       tempImg=tempFing.getFingerPrintImageDetail();
       m_finger.add(tempFing);
       m_bimage.add(tempImg);
       finger.add(tempFinger);
       
       m_panel1.setBufferedImage(m_bimage.get(0));
       jTextField1.setText(m_finger.get(0).ConvertFingerPrintTemplateDoubleToString(finger.get(0)));
       
       m_panel2.setBufferedImage(m_bimage.get(1));
       jTextField2.setText(m_finger.get(1).ConvertFingerPrintTemplateDoubleToString(finger.get(1)));
//    //picture1
//    //Set picture new
//    m_bimage1=ImageIO.read(new File("C:\\Users\\kanchanaR\\Documents\\NetBeansProjects\\BiometricsTest\\build\\classes\\Sample2.bmp")) ;
//    m_panel1.setBufferedImage(m_bimage1);
//    //Send image for skeletinization
//    m_finger1.setFingerPrintImage(m_bimage1) ;
//    finger1=m_finger1.getFingerPrintTemplate();
//     //See what skeletinized image looks like
//    m_bimage1 = m_finger1.getFingerPrintImageDetail();
//    m_panel1.setBufferedImage(m_bimage1);
//    jTextField1.setText(m_finger1.ConvertFingerPrintTemplateDoubleToString(finger1));
//        
//    //picture2
//    //Set picture new
//  //  m_bimage2=ImageIO.read(new File(new java.io.File("").getAbsolutePath()+"\\ProcessedSample2.bmp")) ;
//    m_bimage2=ImageIO.read(new File("C:\\Users\\kanchanaR\\Documents\\NetBeansProjects\\BiometricsTest\\build\\classes\\Sample5.bmp")) ;
//    m_panel2.setBufferedImage(m_bimage2);
//    //Send image for skeletinization
//    m_finger2.setFingerPrintImage(m_bimage2) ;
//    finger2=m_finger2.getFingerPrintTemplate();
//    //See what skeletinized image looks like
//    m_bimage2 = m_finger2.getFingerPrintImageDetail();
//    m_panel2.setBufferedImage(m_bimage2);
//    jTextField2.setText(m_finger2.ConvertFingerPrintTemplateDoubleToString(finger2));
         
      
    
    }
    catch (Exception ex)
    {
    JOptionPane.showMessageDialog (null,ex.getMessage(),"Error",JOptionPane.PLAIN_MESSAGE);
    }        
  }
  private void jButtonStep1_actionPerformed(ActionEvent e)
  {
     //m_finger.ChaneLinkAlgorithm() ;
    //m_panel1.setBufferedImage(m_finger.getFingerPrintImage());
  }

  private void jButtonStep2_actionPerformed(ActionEvent e)
  {
      try
      {
        m_bimage2=ImageIO.read(new File("C:\\Users\\kanchanaR\\Documents\\NetBeansProjects\\BiometricsTest\\build\\classes\\Sample2.bmp")) ;
        //show original image
        m_panel1.setBufferedImage(m_bimage2);
     
       // m_bimage2 = m_fingergfx.getGreyFingerPrintImage(m_bimage2); 
        m_bimage2 = m_fingergfx.BinerizeImage(m_bimage2, 250,180 ); 
        m_panel2.setBufferedImage(m_bimage2);
       }
      catch (Exception ex)
      {
         JOptionPane.showMessageDialog (null,ex.getMessage() ,"Error Message",JOptionPane.PLAIN_MESSAGE);
      }
  }

  private void jButtonStep3_actionPerformed(ActionEvent e)
  {
      //match one print
     try
      {
        JOptionPane.showMessageDialog (null,Double.toString(m_finger.get(0).Match(finger.get(0) , finger.get(1),65,false)),"Match %",JOptionPane.PLAIN_MESSAGE);
      }
      catch (Exception ex)
      {
      JOptionPane.showMessageDialog (null,ex.getMessage() ,"Error Message",JOptionPane.PLAIN_MESSAGE);
      }
  }

  private void jButtonStep4_actionPerformed(ActionEvent e) 
  {
      //match many finger prints
      //used to test matching speed
      //wors at about 1 match every 0,01 seconds needs to become a lot faster
      //the propriety software dose 1 match every 0,0001 a seconds
      try
      {
          int match=0;
          String msg="";
          int h_index=-1;
            for(int i=0;i<m_finger.size();i++){
                  int tempmatch=m_finger.get(0).Match(finger.get(0) , finger.get(i),65,true);
                  msg+=m_finger.get(i).toString()+" - i :"+i+" - match: "+tempmatch+"\n";
                  if(tempmatch>match){
                      h_index=i;
                      match=tempmatch;
                  }
            }
            m_panel2.setBufferedImage(m_bimage.get(h_index));
            jTextField2.setText(m_finger.get(h_index).ConvertFingerPrintTemplateDoubleToString(finger.get(h_index)));
            //JOptionPane.showMessageDialog (null, msg+"\n Match loaded","Match Results",JOptionPane.PLAIN_MESSAGE);
//          
            if(match>=75){
                JOptionPane.showMessageDialog (null, "Good match found:"+m_finger.get(h_index).toString()+" with match "+match,"Match Results",JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog (null, "No Good match. Best available:"+m_finger.get(h_index).toString()+" with match "+match,"Match Results",JOptionPane.PLAIN_MESSAGE);
            }
            
            long res = System.currentTimeMillis();
//         for (int i = 0;i<=20;i++)
//            {
//                m_finger.get(0).Match(finger.get(0) , finger.get(1),65,true);
//                //m_finger1.Match(finger1 , finger2,55,true);
//                if (i == 20)
//                {
//                res=(System.currentTimeMillis()-res)/1000;
//                JOptionPane.showMessageDialog (null, Long.toString(res),"Time to do 20 matches",JOptionPane.PLAIN_MESSAGE);
//                }
//            }
      }
      catch (Exception ex)
      {
      JOptionPane.showMessageDialog (null,ex.getMessage() ,"Error Message",javax.swing.JOptionPane.PLAIN_MESSAGE);
      }
  }

}//End Class entity