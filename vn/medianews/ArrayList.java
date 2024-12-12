
package vn.medianews;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for arrayList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="arrayList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://medianews.vn/}abstractList">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arrayList")
public class ArrayList
    extends AbstractList
{
    protected List<Integer> item;
    public List<Integer> getItem() {
        if (item == null) {
            item = new java.util.ArrayList<Integer>();
        }
        return this.item;
    }

}
