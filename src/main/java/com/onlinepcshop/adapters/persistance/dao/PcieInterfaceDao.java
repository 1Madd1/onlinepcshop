package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity(name = "pcie_interface")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcieInterfaceDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "pcie_type")
    String pcieType;

//    @ManyToMany(mappedBy = "pcieInterfaceList")
//    private List<MotherboardDao> motherboardList;
}
