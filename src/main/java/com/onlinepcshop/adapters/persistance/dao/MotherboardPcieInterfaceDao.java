package com.onlinepcshop.adapters.persistance.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "motherboard_pcie_interface")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotherboardPcieInterfaceDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private MotherboardDao motherboard;

    @ManyToOne
    private PcieInterfaceDao pcieInterface;
}
