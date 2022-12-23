package com.rapidtech.SpiringJson.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rapidtech.SpiringJson.Model.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address_tab")
public class AddressEntity {
    @Id
    @TableGenerator(name = "address_id_generator",table = "sequence_table",
            pkColumnName = "gen_name",valueColumnName = "gen_value",
            pkColumnValue = "address_id",initialValue = 0,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "address_id_generator")
    private Long id;
    @Column(name = "name_jenis",length = 32,nullable = false)
    private String name;

    @Column(name = "address_jl",nullable = false)
    private String address;
    @Column(name = "village",length = 50,nullable = false)
    private String village;
    @Column(name = "district",length = 50,nullable = false)
    private String district;
    @Column(name = "city",length = 50,nullable = false)
    private String city;
    @Column(name = "province",length = 50,nullable = false)
    private String province;
    @Column(name = "customer_id",insertable = false,updatable = false)
    private Long customerId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private CustomerEntity customer;


    public AddressEntity(AddressModel model) {
        this.name = model.getName();
        this.address = model.getAddress();
        this.village = model.getVillage();
        this.district = model.getDistrict();
        this.city = model.getCity();
        this.province = model.getProvince();
    }
}
