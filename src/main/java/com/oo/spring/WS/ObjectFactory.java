
package com.oo.spring.WS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oo.spring.WS package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GeetHell_QNAME = new QName("http://com.test", "geetHell");
    private final static QName _GeetList_QNAME = new QName("http://com.test", "geetList");
    private final static QName _GeetListResponse_QNAME = new QName("http://com.test", "geetListResponse");
    private final static QName _GeetHellResponse_QNAME = new QName("http://com.test", "geetHellResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oo.spring.WS
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GeetList }
     * 
     */
    public GeetList createGeetList() {
        return new GeetList();
    }

    /**
     * Create an instance of {@link GeetHell }
     * 
     */
    public GeetHell createGeetHell() {
        return new GeetHell();
    }

    /**
     * Create an instance of {@link GeetListResponse }
     * 
     */
    public GeetListResponse createGeetListResponse() {
        return new GeetListResponse();
    }

    /**
     * Create an instance of {@link GeetHellResponse }
     * 
     */
    public GeetHellResponse createGeetHellResponse() {
        return new GeetHellResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeetHell }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.test", name = "geetHell")
    public JAXBElement<GeetHell> createGeetHell(GeetHell value) {
        return new JAXBElement<GeetHell>(_GeetHell_QNAME, GeetHell.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeetList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.test", name = "geetList")
    public JAXBElement<GeetList> createGeetList(GeetList value) {
        return new JAXBElement<GeetList>(_GeetList_QNAME, GeetList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeetListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.test", name = "geetListResponse")
    public JAXBElement<GeetListResponse> createGeetListResponse(GeetListResponse value) {
        return new JAXBElement<GeetListResponse>(_GeetListResponse_QNAME, GeetListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeetHellResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.test", name = "geetHellResponse")
    public JAXBElement<GeetHellResponse> createGeetHellResponse(GeetHellResponse value) {
        return new JAXBElement<GeetHellResponse>(_GeetHellResponse_QNAME, GeetHellResponse.class, null, value);
    }

}
