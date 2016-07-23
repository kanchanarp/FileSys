package biometricCompare;

import dbConnector.userHandler;
import java.io.File;
import java.util.ArrayList;
import security.SecurityLevel;

public class CMain {

  public CMain() {
  }
  public static void main(String[] args) {
	  
        ArrayList<SecurityLevel> secList=new ArrayList<SecurityLevel>();
        for(int i=0;i<5;i++){
            SecurityLevel lvl=new SecurityLevel(("L"+i),null);
            secList.add(lvl);
        }
        secList.get(0).setUpLevel(secList.get(1));
        for(int i=1;i<4;i++){
            secList.get(i).setUpLevel(secList.get(i+1));
            secList.get(i).setDownLevel(secList.get(i-1));
        }
        secList.get(4).setDownLevel(secList.get(3));
        secList.get(4).setUpLevel(null);
	userHandler hand=new userHandler();
        try{
            System.out.println(secList.get(3).getUpLevel().getLblLevel());
            hand.info();
        }catch(Exception ex){
            System.out.println("Error");
        }
        
        System.out.println(new java.io.File("").getAbsolutePath()+"\\ProcessedSample2.bmp");
        CEntityForm classFormMain = new CEntityForm();
        classFormMain.setSize(800,800);
        classFormMain.setVisible(true);

  }
}