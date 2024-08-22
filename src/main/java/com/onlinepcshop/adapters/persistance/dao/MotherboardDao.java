package com.onlinepcshop.adapters.persistance.dao;

import com.onlinepcshop.core.domain.entity.PcieInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity(name = "motherboard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotherboardDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "component_name")
    String componentName;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "currency")
    String currency;

    @Column(name = "description")
    String description;

    @Column(name = "image")
    String image;

    @Column(name = "manufacturer")
    String manufacturer;


    @Column(name = "socket_type")
    String socketType;

    @Column(name = "memory_type")
    String memoryType;

    @Column(name = "tdp")
    Integer tdp;
//
//    @ManyToMany
//    @JoinTable(
//            name = "motherboard_pcie_interface",
//            joinColumns = @JoinColumn(name = "pcie_interface_id"),
//            inverseJoinColumns = @JoinColumn(name = "motherboard_id")
//    )
//    List<PcieInterfaceDao> pcieInterfaceList;
//
//    @ManyToMany
//    @JoinTable(
//            name = "motherboard_storage_interface",
//            joinColumns = @JoinColumn(name = "storage_interface_id"),
//            inverseJoinColumns = @JoinColumn(name = "motherboard_id")
//    )
//    List<StorageInterfaceDao> storageInterfaceList;
}
