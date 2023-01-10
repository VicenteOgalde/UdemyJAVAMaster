package cl.vicoga.optional.repository;

import cl.vicoga.optional.model.Computer;

import java.util.Optional;

public interface Repository <T>{
    Optional<Computer> filter(String name);
}
