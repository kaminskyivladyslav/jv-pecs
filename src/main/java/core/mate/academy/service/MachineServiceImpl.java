package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;

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
    public List<T> getAll(Class<? extends T> type) {
        if (type.equals(Excavator.class)) {
            return (List<T>) excavatorProducer.get();
        } else if (type.equals(Truck.class)) {
            return (List<T>) truckProducer.get();
        } else if (type.equals(Bulldozer.class)) {
            return (List<T>) bulldozerProducer.get();
        } else {
            return List.of();
        }
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (T machine : machines) {
            machine.doWork();
        }
    }

}


