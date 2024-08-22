package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity(name = "storage_interface")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageInterfaceDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "storage_type")
    String storageType;

//    @ManyToMany(mappedBy = "storageInterfaceList")
//    private List<MotherboardDao> motherboardList;
}
