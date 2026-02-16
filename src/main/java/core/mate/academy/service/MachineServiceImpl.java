package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of MachineService.
 *
 */
public class MachineServiceImpl<T extends Machine> implements MachineService<T> {
    private final ExcavatorProducer excavatorProducer;
    private final TruckProducer truckProducer;
    private final BulldozerProducer bulldozerProducer;

    public MachineServiceImpl() {
        this.excavatorProducer = new ExcavatorProducer();
        this.truckProducer = new TruckProducer();
        this.bulldozerProducer = new BulldozerProducer();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll(Class<? extends T> type) {
        List<? extends Machine> machines;
        if (type.equals(Excavator.class)) {
            machines = excavatorProducer.get();
        } else if (type.equals(Truck.class)) {
            machines = truckProducer.get();
        } else if (type.equals(Bulldozer.class)) {
            machines = bulldozerProducer.get();
        } else {
            return new ArrayList<>();
        }
        return (List<T>) new ArrayList<>(machines);
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }

}


