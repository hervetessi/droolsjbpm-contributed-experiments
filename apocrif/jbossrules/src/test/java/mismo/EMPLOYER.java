//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.05.19 at 04:51:31 AM BST 
//


package mismo;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="CurrentEmploymentMonthsOnJob" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="CurrentEmploymentYearsOnJob" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="EmploymentBorrowerSelfEmployedIndicator" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="EmploymentCurrentIndicator" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="EmploymentPrimaryIndicator" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="_City" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="_Name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="_PostalCode" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="_State" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="_StreetAddress" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "EMPLOYER")
public class EMPLOYER {

    @XmlAttribute(name = "CurrentEmploymentMonthsOnJob", required = true)
    protected BigInteger currentEmploymentMonthsOnJob;
    @XmlAttribute(name = "CurrentEmploymentYearsOnJob", required = true)
    protected BigInteger currentEmploymentYearsOnJob;
    @XmlAttribute(name = "EmploymentBorrowerSelfEmployedIndicator", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String employmentBorrowerSelfEmployedIndicator;
    @XmlAttribute(name = "EmploymentCurrentIndicator", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String employmentCurrentIndicator;
    @XmlAttribute(name = "EmploymentPrimaryIndicator", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String employmentPrimaryIndicator;
    @XmlAttribute(name = "_City", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String city;
    @XmlAttribute(name = "_Name", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String name;
    @XmlAttribute(name = "_PostalCode", required = true)
    protected BigInteger postalCode;
    @XmlAttribute(name = "_State", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String state;
    @XmlAttribute(name = "_StreetAddress", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String streetAddress;

    /**
     * Gets the value of the currentEmploymentMonthsOnJob property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCurrentEmploymentMonthsOnJob() {
        return currentEmploymentMonthsOnJob;
    }

    /**
     * Sets the value of the currentEmploymentMonthsOnJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCurrentEmploymentMonthsOnJob(BigInteger value) {
        this.currentEmploymentMonthsOnJob = value;
    }

    /**
     * Gets the value of the currentEmploymentYearsOnJob property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCurrentEmploymentYearsOnJob() {
        return currentEmploymentYearsOnJob;
    }

    /**
     * Sets the value of the currentEmploymentYearsOnJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCurrentEmploymentYearsOnJob(BigInteger value) {
        this.currentEmploymentYearsOnJob = value;
    }

    /**
     * Gets the value of the employmentBorrowerSelfEmployedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmploymentBorrowerSelfEmployedIndicator() {
        return employmentBorrowerSelfEmployedIndicator;
    }

    /**
     * Sets the value of the employmentBorrowerSelfEmployedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmploymentBorrowerSelfEmployedIndicator(String value) {
        this.employmentBorrowerSelfEmployedIndicator = value;
    }

    /**
     * Gets the value of the employmentCurrentIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmploymentCurrentIndicator() {
        return employmentCurrentIndicator;
    }

    /**
     * Sets the value of the employmentCurrentIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmploymentCurrentIndicator(String value) {
        this.employmentCurrentIndicator = value;
    }

    /**
     * Gets the value of the employmentPrimaryIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmploymentPrimaryIndicator() {
        return employmentPrimaryIndicator;
    }

    /**
     * Sets the value of the employmentPrimaryIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmploymentPrimaryIndicator(String value) {
        this.employmentPrimaryIndicator = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPostalCode(BigInteger value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the streetAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets the value of the streetAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetAddress(String value) {
        this.streetAddress = value;
    }

}
