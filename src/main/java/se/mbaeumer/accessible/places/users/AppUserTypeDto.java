package se.mbaeumer.accessible.places.users;

import jakarta.persistence.Column;

public class AppUserTypeDto {
    private Integer id;

    private String name;

    private String description;

    private AppUserTypeDto(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static AppUserTypeDto of(AppUserType appUserType){
        return new AppUserTypeDto(appUserType.getId(), appUserType.getName(), appUserType.getDescription());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
