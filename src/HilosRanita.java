import java.util.Random;

public class HilosRanita extends Thread {

	private int num;
	private int rana;
	private int pasos;
	private int contRana;
	private Random rn = new Random();
	private int[] avance = {-1,1};
	private Ventana ventana;
	
	public HilosRanita(int num, int contRana, Ventana ventana) {
		this.num = num;
		this.contRana = contRana+1;
		this.ventana=ventana;
	}
	
	public void run() {
		
		pasos = 0;
		rana = 10;
		switch(num) {
			case 0:
			case 1:
			case 2:
				while (rana!=0 && rana!=20) {
					try {
						sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(rn.nextInt(2)==0)
						rana--;
					else
						rana++;
					ventana.actualizar(rana, num);
					pasos++;
					System.out.println("Rana "+contRana+" "+rana);
				}
				System.out.println("\nRana "+contRana+" llegó en "+pasos+" pasos");
				
				break;
			
			case 3:
			case 4:
			case 5:
				while (rana!=0 && rana!=20) {
					try {
						sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rana = rana + avance[rn.nextInt(2)];
					ventana.actualizar(rana, num);
					pasos++;
					System.out.println("Rana "+contRana+" "+rana);
				}
				System.out.println("\nRana "+contRana+" llegó en "+pasos+" pasos");
				
				break;
			
		}
	}
}
class EjecutarRana {
	public static void main(String[] args) {
		HilosRanita ranas[] = new HilosRanita[6];
		Ventana ventana=new Ventana();
		
		for (int i = 0; i<ranas.length; i++) {
			ranas[i] = new HilosRanita(i,i, ventana);
			ranas[i].start();
		}
	
		for (int i = 0; i<ranas.length; i++) {
			try {
				ranas[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
	

