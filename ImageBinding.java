package Praktikum1;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.image.Image;

public class ImageBinding extends ObjectBinding<Image> {
	int index;
	int offset;
	Image[] imageArray = {
			
			new Image("file:///C:/Users/Magellan/Pictures/pic"+ 0 +".png"),
			new Image("file:///C:/Users/Magellan/Pictures/pic"+ 2 +".png"), 
			new Image("file:///C:/Users/Magellan/Pictures/pic"+ 3 +".png"),
			new Image("file:///C:/Users/Magellan/Pictures/pic"+ 1 +".png"),
			new Image("file:///C:/Users/Magellan/Pictures/pic"+ 4 +".png"),
			new Image("file:///C:/Users/Magellan/Pictures/pic"+ 5 +".png"),
			
			};
	
	private ReadOnlyObjectProperty<Integer> property;
	 
	public ImageBinding( ReadOnlyObjectProperty<Integer> property, int offset) {
		super.bind(property);
		this.property= property;
		this.offset = offset;
	}
	//Es wird aufgerufen, wenn sich das Integer-Property ändert.
	//Diese Methode berechnet den Index des aktuellen Bilds basierend auf dem Wert des Integer-Property und gibt das Bild züruck
	@Override
	protected Image computeValue() {
		if(property.getValue() == null) {
			return getImage(0);
		}

		index= property.getValue();
		return getImage(index);
	}
	
	//Diese Methode gibt das Image-Objekt für den angegebenen Index zurück.
	//Es wird auch das Offset berücksichtigt, so dass  das richtige Bild aus dem Array ausgewaählt wird
	public Image getImage(int index) {
		
		Image im= null;
		if(index + this.offset < 0) {
			im= imageArray[imageArray.length + this.offset];
			return  im;
		}
		if (index + this.offset >= imageArray.length) {
            return imageArray[this.offset-1];
		}
        else {
            return imageArray[index + this.offset];
        }
	}
}