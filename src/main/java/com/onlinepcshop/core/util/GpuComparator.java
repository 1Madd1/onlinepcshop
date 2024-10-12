package com.onlinepcshop.core.util;

import com.onlinepcshop.core.domain.entity.Gpu;

import java.util.Comparator;

public class GpuComparator implements Comparator<Gpu> {
    @Override
    public int compare(Gpu gpu1, Gpu gpu2) {
        return gpu1.getPrice().getAmount().compareTo(gpu2.getPrice().getAmount());
    }
}
