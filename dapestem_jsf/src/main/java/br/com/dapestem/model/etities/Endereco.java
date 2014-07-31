

package br.com.dapestem.model.etities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdEndereco", nullable=false)
    private Integer idEndereco;
    @Column(name="Bairro", length=70)
    private String bairro;
    @Column (name="Logradouro", length=80)
    private String logradouro;
    @Column (name="CEP", length=9)
    private String cep;
    @Column (name="Numero")
    private Integer numero;
    @Column (name="Complemento")
    private Integer complemento;
    
    //uma pessoa tem um endereço, assim como um endereço é de uma pessoa(one to one) 
    //(optnional true) uma pessoa pode ser cadastrada sem digitar o endereço
    //fetchtype"LAZY" vai trazer os endereços quando especificados - "EAGER" vai trazer todos os endereços toda vez
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoPessoa")
    @JoinColumn(name="IdPessoa", referencedColumnName = "IdPessoa")
    private Pessoa pessoa;
        
    //manytoone(muitos para um)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoLogradouro")
    @JoinColumn(name = "IdTipoLogradouro", referencedColumnName = "idTipoLogradouro")
    private TipoLogradouro tipologradouro;
    
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoCidade")
    @JoinColumn(name = "IdCidade", referencedColumnName = "idCidade")
    private Cidade cidade;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoEstado")
    @JoinColumn(name="IdEstado", nullable = false)
    private Estado estado;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name ="EnderecoTipoEndereco")
    @JoinColumn(name="IdTipoEndereco", referencedColumnName = "IdTipoEndereco")
    private TipoEndereco tipoendereco;

    public Endereco() {
    
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipologradouro = new TipoLogradouro();
        this.tipoendereco = new TipoEndereco();
        this.pessoa = new Pessoa();
        
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getComplemento() {
        return complemento;
    }

    public void setComplemento(Integer complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipologradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipologradouro = tipoLogradouro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoendereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoendereco = tipoEndereco;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.idEndereco != null ? this.idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco && (this.idEndereco == null || !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }
    
    
    
}
