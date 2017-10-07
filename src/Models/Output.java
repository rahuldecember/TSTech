package Models;

public class Output {

	private String title;
//	private String link;
//	private String description;
	private Items items;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Items getItems() {
		return items;
	}
	
	public void setItems(Items items) {
		this.items = items;
	}
}
