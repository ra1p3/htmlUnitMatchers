package foo;

import org.hamcrest.Description;
import org.hamcrest.Factory;

import com.gargoylesoftware.htmlunit.html.DomNode;
import com.moonillusions.htmlUnitMatchers.StringUtils;

public class AttributeCountMatcher extends MyTypeSafeMatcher<DomNode> {
	
	private int count;

	public AttributeCountMatcher(int count) {
		this.count = count;
	}

	@Override
	protected void mismatch(DomNode item, Description mismatchDescription) {
		mismatchDescription.appendText(StringUtils.print(item) + 
				String.format(" has %s attributes instead of the expected %s",
						attributeCount(item),
						this.count));
		
	}

	@Override
	protected boolean match(DomNode item) {
		// TODO Auto-generated method stub
		return attributeCount(item) == this.count;
	}

	private int attributeCount(DomNode item) {
		return item.getAttributes().getLength();
	}

	@Override
	protected void describe(Description arg0) {
		arg0.appendText(String.format("Has %s attributes", this.count));
		
	}
	
	
	@Factory
	public static AttributeCountMatcher hasAttributes(int count) {
	    return new AttributeCountMatcher(count);
	}

	

}
