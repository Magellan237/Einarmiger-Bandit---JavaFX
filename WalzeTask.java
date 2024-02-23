package Praktikum1;

import java.util.Random;

import javafx.concurrent.Task;

public class WalzeTask extends Task<Integer>{
	
	private int imageAnzahl;
	int index;
	int bildwechseln= new Random().nextInt(5) +50;
	
	public WalzeTask(int imageAnzahl ) {
		//super();
		this.imageAnzahl = imageAnzahl;
		this.index= 0;
	}
	//Die call-Methode f�hrt eine Schleife aus,die die Anzahl der zuf�lligen Bildwechsel durchla�ft.
	@Override
	protected Integer call() throws Exception {
		int time = 100;
		System.out.println("Zuf�llige Anzanhl Bildwechseln: " + bildwechseln);
		System.out.println("--------------------------------------------");
		for (int i=0; i< bildwechseln; i++) {
			index ++;
			System.out.println("Index : " + index);
			System.out.println("--------------------------------------------");
			if(imageAnzahl == index) {
				index=0;
			}
			//gib den aktuellen index zur�ck 
			updateValue(index);
			System.out.println("Index_Update: " + index);
			Thread.sleep(time);//erzeugt eine kurze Verz�gerung zwischen den Bildwechseln,die in jedem Durchlauf zunimmt
			time++;
		}
		return index;
	}
	
}

