import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
	
	JSlider[] rana=new JSlider[6];
	JLabel [] pos=new JLabel[6];
	
	
	
	public Ventana() {
		super("Ranas");
		setSize(600,600);
		GridLayout layout=new GridLayout(6,2);
		setLayout(layout);
		
		Icon icono = new ImageIcon("image/rana.jpg");
		UIDefaults defaults = UIManager.getDefaults();
		defaults.put("Slider.horizontalThumbIcon", icono);
		
		for(int i=0;i<rana.length;i++){
			rana[i]=new JSlider(0,20);
			pos[i]=new JLabel("10");
			this.add(pos[i]);
			this.add(rana[i]);
		}
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actualizar(int rana, int num) {
		pos[num].setText(String.valueOf(rana));
		this.rana[num].setValue(rana);
		if(rana==0 || rana==20) {
			this.rana[num].setBackground(Color.BLUE);
		}
	}
	
}
