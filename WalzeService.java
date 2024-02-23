package Praktikum1;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class WalzeService extends Service<Integer> {
	private int bildAnzahl;
	
	public WalzeService(int bildAnzahl) {
		this.bildAnzahl= bildAnzahl;
		
	}
	//Die Methode erstellt und gibt eine neue Instanz der Klasse WalzeTask zurück
	//Die Klasse WT ist eine innere Klasse von WS,die von der abstrakten Klasse 'Task<Integer> erbt.
	
	@Override
	protected Task<Integer> createTask() {
		
		return new WalzeTask(this.bildAnzahl);
	}
	//Durch die Verwendung von WalzeTask in createTask wird WalzeService in der lage sein, den Hintergrund-Thread auszuführen
	//und den Index des aktuellen Bildes zu erhalten
}