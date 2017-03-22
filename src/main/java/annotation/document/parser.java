/**
 * 
 */
package annotation.document;

import org.jsoup.select.Elements;

class parser {

	@xpath(value = "//a")
	private Elements elements;

	public Elements getElements() {
		return elements;
	}

	public void setElements(Elements elements) {
		this.elements = elements;
	}
}
