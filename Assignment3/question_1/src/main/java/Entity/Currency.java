/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author riya vesuwala
 */
@Entity
@Table(name = "currency")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
    @NamedQuery(name = "Currency.findByCurrencyCode", query = "SELECT c FROM Currency c WHERE c.currencyCode = :currencyCode"),
    @NamedQuery(name = "Currency.findByCurrencyName", query = "SELECT c FROM Currency c WHERE c.currencyName = :currencyName")})
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "currency_code")
    private String currencyCode;
    @Size(max = 200)
    @Column(name = "currency_name")
    private String currencyName;
    @OneToMany(mappedBy = "fromCurrency")
    private Collection<Conversionrate> conversionrateCollection;
    @OneToMany(mappedBy = "toCurrency")
    private Collection<Conversionrate> conversionrateCollection1;

    public Currency() {
    }

    public Currency(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @XmlTransient
    public Collection<Conversionrate> getConversionrateCollection() {
        return conversionrateCollection;
    }

    public void setConversionrateCollection(Collection<Conversionrate> conversionrateCollection) {
        this.conversionrateCollection = conversionrateCollection;
    }

    @XmlTransient
    public Collection<Conversionrate> getConversionrateCollection1() {
        return conversionrateCollection1;
    }

    public void setConversionrateCollection1(Collection<Conversionrate> conversionrateCollection1) {
        this.conversionrateCollection1 = conversionrateCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyCode != null ? currencyCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.currencyCode == null && other.currencyCode != null) || (this.currencyCode != null && !this.currencyCode.equals(other.currencyCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Currency[ currencyCode=" + currencyCode + " ]";
    }
    
}
