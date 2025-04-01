package org.example;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
public class Employee {

    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (o == this)
            return true;
        return (this.getId() == ((Employee)o).getId());
    }

}
