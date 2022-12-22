package com.rapidtech.SpiringJson.Entity;

import com.rapidtech.SpiringJson.Model.SchoolModel;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "school_tab")
public class SchoolEntity {
    @Id
    @TableGenerator(name = "id_generator",table = "sequence_table",
            pkColumnName = "gen_name",valueColumnName = "gen_value",
            pkColumnValue = "school_id",initialValue = 0,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "id_generator")
    private Long id;
    @Column(name = "title",length = 10,nullable = false)
    private String title;
    @Column(name = "name_school",length = 100,nullable = false)
    private String name;
    @Column(name = "level",length = 30,nullable = false)
    private String level;
    @Column(name = "customer_id",length = 32,nullable = false)
    private Long customerId;

    @ManyToOne
    @JoinColumn(name = "customer_id",insertable = false,updatable = false)
    private CustomerEntity customer;

    public SchoolEntity(SchoolModel model) {
        this.title = model.getTitle();
        this.name = model.getName();
        this.level = model.getLevel();
    }
}
