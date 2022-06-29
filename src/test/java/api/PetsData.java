package api;

import java.util.ArrayList;

public class PetsData {
    public Integer id;
    public Category category;
    public String name;
    public String status;

    public PetsData(Integer id, Category category, String name, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
