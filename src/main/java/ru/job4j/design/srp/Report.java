package ru.job4j.design.srp;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public interface Report {

    public String generate(List<Employer> list) throws IOException;

}

