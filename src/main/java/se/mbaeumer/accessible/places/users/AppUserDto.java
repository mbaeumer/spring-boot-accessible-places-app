package se.mbaeumer.accessible.places.users;

public class AppUserDto {
    private Integer id;

    private String name;

    private String email;

    private AppUserTypeDto userType;

    private AppUserDto(Integer id, String name, String email, AppUserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = AppUserTypeDto.of(userType);
    }

    public static AppUserDto of(AppUser appUser){
        return new AppUserDto(appUser.getId(), appUser.getName(), appUser.getEmail(), appUser.getUserType());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppUserTypeDto getUserType() {
        return userType;
    }

    public void setUserType(AppUserTypeDto userType) {
        this.userType = userType;
    }
}
