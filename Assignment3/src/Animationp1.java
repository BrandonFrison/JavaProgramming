import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Animationp1 extends JFrame{
    JLabel picture; //jlabel initialize
    Timer time; //timer initialize
    int x = 0; //initialize starting img value

    //String array of a list of all images
    String[] list = {
                      "img1.png",
                      "img2.png",
                      "img3.png",
                      "img4.png",
                      "img5.png",
                      "img6.png",
                      "img7.png",
                      "img8.png",
                      "img9.png",
                      "img10.png",
                      "img11.png",
                      "img12.png",
                      "img13.png",
                      "img14.png",
                      "img15.png",
                      "img16.png",
                      "img17.png",
                      "img18.png",
                      "img19.png",
                      "img20.png",
                      "img21.png",
                      "img22.png",
                      "img23.png",
                      "img24.png",
                      "img25.png",
                      "img26.png",
                      "img27.png",
                      "img28.png",
                      "img29.png",
                      "img30.png",
                      "img31.png",
                      "img32.png",
                      "img33.png",
                      "img34.png",
                      "img35.png",
                      "img36.png",
                      "img37.png",
                      "img38.png",
                      "img39.png",
                      "img40.png",
                      "img41.png",
                      "img42.png",
                      "img43.png",
                      "img44.png",
                      "img45.png",
                      "img46.png",
                      "img47.png",
                      "img48.png",
                      "img49.png",
                      "img50.png",
                    };

    public Animationp1(){
        super("Java SlideShow");
        picture = new JLabel(); //creates JLabel object
        picture.setBounds(0, 0, 700, 500);  //sets the picture size to 700 by 500 starting from 0,0 the top left corner

        //not sure what this does but it is needed according to someone on stack overflow
        ResizeImages(0);
       
       //sets a timer for 500 miliseconds
        time = new Timer(500,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	ResizeImages(x); //sets the correct img in the array next
                x += 1;
                if(x >= list.length ){
                    x = 0; 
                }
            }
});
        add(picture);
        time.start(); //starts the timer
        setLayout(null);
        setSize(720, 540); //slightly different dimensions worked better not sure why
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
}
    //this is a function which will resize the image 
    public void ResizeImages(int o){
        ImageIcon icon = new ImageIcon(list[o]);
        Image img = icon.getImage();
        Image nextImg = img.getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon nextImcn = new ImageIcon(nextImg);
        picture.setIcon(nextImcn);
}

public static void main(String[] args){ 
      
    new Animationp1(); //creates the object to start the animation
	}
}